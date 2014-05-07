-- Warren Smith
-- CSC435-01
-- Date Submitted: 4/17/14
-- Assignment #4: Haskell Dustsweeper
-- Main.hs (Driver class)

import Dustsweeper
import Control.Monad
import qualified Data.Map as M
import qualified Data.Set as S
import Data.Map(Map)
import Data.Char
 

-- Main method that runs game  
main :: IO ()
main = do
	putStrLn "\n -- Welcome to the Dustsweeper Game -- \n\n"
	
	putStrLn "Board Options:"
	putStrLn "--------------"
	putStrLn "Enter the board width: "
	line <- getLine
	let width = read line :: Int
 
	putStrLn "Enter the board height: "
	line <- getLine
	let height = read line :: Int
 
	putStrLn "Enter the number of dust balls: "
	line <- getLine
	let n = read line :: Int
	 
	putStr "\n\n"
	 
	if (width < 0 || height < 0 || (width*height) < n) then
		putStrLn "** Invalid board options, please try again **\n" >> main
	else do
		gameSt <- (createBoard (width,height) n) -- creates game board
		
		putStrLn "The Game Board:"
		putStrLn "---------------\n"
		showBoard gameSt -- shows game board
		
		putStrLn ""
		--showInternal gameSt -- shows solution board (testing)
		
		userInput gameSt -- prompts user to make moves
		
		return ()



		
-- 	Shows current game board	
showBoard :: StateOfGm -> IO ()
showBoard gameSt = do
	putStr "  " 
	putStrLn . unwords $ map show [1..width] -- Print columns
 
	-- Print rows
	putStrLn " ::::::::"
	printRow 1 height gameSt
 
	where
		(width,height) = getBounds gameSt
		printRow n t gameSt =
			if (n > t) then do
				return ()
			else do
				putStr ((show n) ++ ":")
				putStrLn . unwords $ rowHelp (rowSquares n gameSt)
				printRow (n+1) t gameSt

			where
				rowSquares n gameSt = M.filterWithKey (\(x,y) s -> y == n) (getBoard gameSt)
				cellHelp Flagged = "F"
				cellHelp (Adjacent n) = show n
				cellHelp _ = " "
				rowHelp squares = [cellHelp s|(_,s) <- (M.toList squares)]


-- Shows solution board (internal)... Used only for testing				
showInternal :: StateOfGm -> IO ()
showInternal gameSt = do 
	putStr "  "
	putStrLn . unwords $ map show [1..width] -- Print columns
 
	-- Print rows
	putStrLn " ::::::::" 
	printRow 1 height gameSt
 
	where
		(width,height) = getBounds gameSt
		printRow n t gameSt =
			if (n > t) then do
				return ()
			else do
				putStr ((show n) ++ ":")
				putStrLn . unwords $ rowHelp (rowSquares n gameSt)
				printRow (n+1) t gameSt
 
			where
				rowSquares n gameSt = M.filterWithKey (\(x,y) s -> y == n) (getInternal gameSt)
				cellHelp DustBall = "D"
				cellHelp (IAdjacent n) = show n
				rowHelp squares = [cellHelp s|(_,s) <- (M.toList squares)]


-- Prompts user take make moves				
userInput :: StateOfGm -> IO ()
userInput gameSt = do
	putStrLn ""
	putStrLn "What is your move? (c = check, f = flag, q = quit):"
	line <- getLine
	case (dropWhile isSpace $ takeWhile (not . isSpace) line) of
		"f" -> do
			putStrLn "Enter the rug to flag, in (col, row) format:"
			line <- getLine
			let pos = read line :: (Int, Int)
 
			case (makeMve (Move Flag pos) gameSt) of
				(Left Win) -> do
					putStrLn "You did it! Winner!!"
				(Left Lose) -> do
					putStrLn "Oh no, you slipped on a dust ball! You Lose..."
				(Right gameSt') -> do
					putStrLn ""
					showBoard gameSt'
					userInput gameSt'
		"c" -> do
			putStrLn "Enter the rug to check, in (col, row) format:"
			line <- getLine
			let pos = read line :: (Int, Int)
 
			case (makeMve (Move Click pos) gameSt) of
				(Left Win) -> do
					putStrLn "You did it! Winner!!"
				(Left Lose) -> do
					putStrLn "Oh no, you slipped on a dust ball! You Lose..."
				(Right gameSt') -> do
					putStrLn ""
					showBoard gameSt'
					userInput gameSt'
		"q" -> do
			return ()
		_ -> do
			userInput gameSt