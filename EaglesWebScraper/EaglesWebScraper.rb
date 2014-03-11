#	Warren Smith
#	CSC435-01
#	
#	EagleWebScrape.rb
# 	Last Modified: 2/4/14
#	Description: Goes on nfl.com to collect/display important data 
#				 about each current player on the Eagles roster

require 'scraperwiki'
require 'nokogiri'

# Sets the url for the site that the data will be collected from
html = ScraperWiki.scrape("http://www.nfl.com/players/search?category=team&filter=3700&playerType=current")

# Set variable "doc" to parser gem (Nokogiri)
doc = Nokogiri::HTML(html)

i = 1
j = 30

# Header
puts
puts "  Welcome to the Philadelphia Eagles Roster Viewer"
puts
puts "*  This system displays basic information on all *"
puts "* the current Eagles players. Updates as site does *"
puts
puts "-----------------------------------------------------"
puts

# Block that extracts/prints first half of roster list
doc.search("tr[@class = 'even']").each do |row|
	name = row.search('a/text()')
    cells = row.search('td/text()')
	
	# Set each data piece to own variable
	p1 = name[0].text
	p2 = cells[1].text
	p3 = cells[0].text
	p4 = cells[2].text
	
	# Prints player data
	if i < 10
		puts "#" + i.to_s + ".  " + p1 
	else
		puts "#" + i.to_s + ". " + p1 
	end
	
	puts "     - Jersey # = " << p2 
	puts "     - Position = " << p3 
	puts "     - Status = " << p4
	puts
	
	i = i+1
	
	end

# Block that extracts/prints second half of roster list	
doc.search("tr[@class = 'odd']").each do |row|
	name = row.search('a/text()')
    cells = row.search('td/text()')
	
	# Set each data piece to own variable
	p1 = name[0].text
	p2 = cells[1].text
	p3 = cells[0].text
	p4 = cells[2].text
	
	# Prints player data
	puts "#" + j.to_s + ". " + p1 
	puts "     - Jersey # = " << p2 
	puts "     - Position = " << p3 
	puts "     - Status = " << p4
	puts
	
	j = j+1
	
	end