-- Warren Smith
-- CSC435-01
-- Date Submitted: 4/17/14
-- Assignment #4: Haskell Dustsweeper
-- DustSweeper.hs (Defines DustSweeper module)

module Dustsweeper
( Pos
, Move(..)
, MoveType(..)
, Square(..)
, InsideSquare(..)
, createBoard
, getBounds
, getBoard
, getInternal
, makeMve
, StateOfGm
, GmOver(..)
) where
 
import Control.Monad
import qualified Data.Map as M
import qualified Data.Set as S
import Data.Map(Map)
import System.Random
 
 
-- Define position on a board
type Pos = (Int, Int) -- (col, row) coordinates

 
-- Defines types of moves that can be done
data Move = Move MoveType Pos deriving (Eq, Show)
data MoveType = Click | Flag deriving (Eq, Show)

 
-- Defines possible states of a cell in the board
data Square
	= Undiscovered
	| Clicked
	| Flagged
	| Adjacent Int
	-- the number of adjacent rugs
	deriving (Eq, Show)

	
-- Defines information about rugs internally
data InsideSquare
	= DustBall -- is a dust ball
	| IAdjacent Int -- not a dust ball, but has n ones
	deriving (Eq, Show)

	
-- Defines board being valid size  
inBounds :: Pos -> (Int, Int) -> Bool
inBounds (x,y) (width,height) = x >= 1 && y >= 1 && x <= width && y <= height

getBounds :: StateOfGm -> (Int, Int)
getBounds (StateOfGm bounds _ _) = bounds


-- Defines getting board size
getBoard :: StateOfGm -> Map Pos Square
getBoard (StateOfGm _ board _) = board


-- Defines getting solution board (internal) 
getInternal :: StateOfGm -> Map Pos InsideSquare
getInternal (StateOfGm _ _ internal) = internal


-- Defines adjacent positions 
adjacentPositions :: Pos -> [Pos]
adjacentPositions (x,y) = [(x-1,y-1),(x-1,y),(x-1,y+1),(x,y+1),(x+1,y+1),(x+1,y),(x+1,y-1),(x,y-1)]


-- Defines a position move 
movePos :: Move -> Pos
movePos (Move _ pos) = pos


-- Checks for valid move 
validMove :: Move -> StateOfGm -> Bool
validMove (Move _ (x,y)) (StateOfGm (width,height) squares _) =
	if (not(inBounds (x,y) (width,height))) then
		False
	else
		case square of 
			Just Undiscovered -> True
			Just Flagged -> True
			_ -> False
	where
		square = M.lookup (x,y) squares

		
-- Defines all cells
allPositions :: (Int, Int) -> [Pos]
allPositions (width,height) = getRow width height
	where
		getCellsOfRow 1 y = [(1,y)]
		getCellsOfRow x y = (x,y) : getCellsOfRow (x-1) y
		getRow width 1 = getCellsOfRow width 1
		getRow width y = getCellsOfRow width y ++ getRow width (y-1)

		
-- Creates the game board		
createBoard :: (Int, Int) -> Int -> IO StateOfGm
createBoard (width,height) num = do
	let poss = allPositions (width,height)
	dustBalls <- getRand num (width,height) []
	let board = foldr (\pos acc -> (pos,Undiscovered):acc) [] poss
	let internal = foldr (\pos acc -> if (elem pos dustBalls) then (pos,DustBall):acc else let adjacent = foldr (\adjPos acc -> if (elem adjPos dustBalls) then 1+acc else acc) 0 (adjacentPositions pos) in (pos,IAdjacent adjacent):acc) [] poss
	let state = StateOfGm (width,height) (M.fromList board) (M.fromList internal)
	return state
 
	where
		getRand 0 _ dustBalls =
			return dustBalls
		getRand n (width, height) dustBalls = do
			x <- getStdRandom(randomR (1, width))
			y <- getStdRandom(randomR (1, height))
			if elem (x,y) dustBalls then
				getRand n (width, height) dustBalls
			else
				getRand (n-1) (width, height) ((x, y):dustBalls)

				
-- Checks the current state of game board				
checkState :: StateOfGm -> Either GmOver StateOfGm
checkState gs =
	if (not(M.null(M.intersection clicked dustBalls))) then
		Left Lose
	else if (M.null (M.difference unclicked dustBalls)) then
		Left Win
	else
		Right gs
	where
		clicked = M.filter (\square -> square == Clicked) (getBoard gs)
		unclicked = M.filter (\square -> square == Undiscovered || square == Flagged) (getBoard gs)
		dustBalls = M.filter (\square -> square == DustBall) (getInternal gs)

		
-- Defines making a move and filling in appropriate cell 
makeMve :: Move -> StateOfGm -> Either GmOver StateOfGm
makeMve (Move mvtype pos) (gs) =
	if (mvtype == Click) then
		checkState(click pos gs)
	else
		checkState(flag pos gs)
 
fill :: Pos -> S.Set Pos -> StateOfGm -> (S.Set Pos, StateOfGm)
fill pos visited gs =
	if (S.member pos visited) then
		(visited,gs)
	else
		case isquare of 
			(Just (IAdjacent n)) -> if (n == 0) then
										fillHelper (adjacentPositions pos) (S.insert pos visited) (StateOfGm (getBounds gs) (M.alter (\x -> Just (Adjacent n)) pos (getBoard gs)) (getInternal gs))
									else
										fillHelper [] (S.insert pos visited) (StateOfGm (getBounds gs) (M.alter (\x -> Just (Adjacent n)) pos (getBoard gs)) (getInternal gs))
			_ 					 -> (visited, gs)
	where
		isquare = M.lookup pos (getInternal gs)
		fillHelper [] visited gs = (visited,gs)
		fillHelper (pos:poss) visited gs =
			if (inBounds pos (getBounds gs)) then
				let (visited', gs') = fill pos visited gs in
				fillHelper poss visited' gs'
			else
				fillHelper poss (visited) gs

				
-- Defines the current state of board
data StateOfGm
	= StateOfGm
	(Int, Int) -- Size of board (horizontal, vertical)
	(Map Pos Square) -- The user visible board
	(Map Pos InsideSquare) -- Internal dust ball info
	deriving Show


-- Defines a click (check) move				
click :: Pos -> StateOfGm -> StateOfGm
click pos gs = case isquare of 
					Just DustBall -> (StateOfGm (getBounds gs) (M.alter (\x -> Just Clicked) pos (getBoard gs)) (getInternal gs))
					Just (IAdjacent an) -> gs'
	where
		isquare = M.lookup pos (getInternal gs)
		(_, gs') = fill pos (S.empty) gs

		
-- Defines a flag move		
flag :: Pos -> StateOfGm -> StateOfGm
flag pos gs = case square of 
					Just Flagged 		-> (StateOfGm (getBounds gs) (M.alter (\x -> Just Undiscovered) pos (getBoard gs)) (getInternal gs))
					Just Undiscovered 	-> (StateOfGm (getBounds gs) (M.alter (\x -> Just Flagged) pos (getBoard gs)) (getInternal gs))
	where
		square = M.lookup pos (getBoard gs)

		
-- Defines win or lose senerio 
data GmOver = Win | Lose deriving (Eq, Show)