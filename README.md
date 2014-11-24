SRW MX Portable Static Data Editor
---------------------------------------

This program allows you to edit the contents of the DATA.BIN file extracted from STATIC2_ADD.BIN using the Static Splitter application.


How to use this:

I think it's pretty straightforward, but here's some basics:

1) Go to File -> Open and browse for DATA.BIN (that you'll have extracted beforehand).

2) Once you open the file, the Navigation panel (under the menu bar) will be activated and will allow you to choose a category to edit. Depending on the chosen category, you may get a hint in red text next to the combobox with category names, which you should keep in mind (sometimes it's about size restrictions for the text).

3) You'll get a list of numbered panels with (at least) two text areas. Inside these, the one on the left shows the text read originally, the one on the right is where you write your translation (initially has the same original text). There's one category that gives you *four* text areas instead of two (Multi - Location names), but it's still not clear if the second set of text (the terrain type) is actually used by the game.

4) You can ignore the Tools menu and the "Convert keystrokes to SJIS" option, those are there just in case somebody decides to use VWF in the future.

6) Once you're done editing, go to "File -> Save as..." to save your modifications as another BIN file. The file saved through this CAN'T BE USED BY THE GAME. Well, it can, but the game will probably crash. The reason I tell you to save in this format is because if you open your saved file again, you'll be able to read the quotes the way you wrote them. The other save option saves the text after converting every letter pair into kanji, which you most probably won't understand. ALWAYS make a save of your edits with this method.

7) To save your edits as a file that the game can read, you have to use "File -> Convert and Save as...". You should only do this when you want to create files to insert into the game.

8) Don't forget to use the Static Splitter to create a new STATIC2_ADD.BIN with your edited (and converted) DATA.BIN before inserting it back into the game (DATA.BIN is useless otherwise).


IMPORTANT NOTES:

* Keep backups!

* Some categories take a pretty long time to load, chiefly "Sent - Robot Library" and "Sent - Character Library". this is because the first one has 1000+ entries and the second one 3000+. Sorry for the inconvenience.

* The application hasn't been thoroughly tested and the padding of certain parts of the file is handled with a lot of guesswork. That means it's not 100% guaranteed that the edited data will work (meanin it won't crash the game in the "Now Loading" screen). The causes for these crashes are more or less accounted for, so please contact me if an edit doesn't work.

* A well-known way of crashing the game with this is producing a DATA.BIN smaller than the originally extracted. Not entirely sure what will happen if the generated DATA.BIN is bigger. Just in case, try not to write too much in the categories that don't specify any size restrictions.

* Some categories have no size restrictions, but the window screen in the game naturally limits those. You'll have to check the existing lines and what do they look like ingame to know how many characters are allowed. As a rule, if you can fit n SJIS characters, then you can fit 2*n ASCII characters.

* In the category "Sent - Help strings" you get a hint mentioning entries #157 and #158 have special characters. These are '‡_' (miri - milimetres), '‡j' (doru... not sure what this is) and '‡d' (ton - as in the weight measure). These characters are actually displayed ingame as a little fist, a fist next to crosshairs and a crosshairs symbol, respectively. Obviously, we want to keep these symbols, so you'll have to write the translation around those keeping one important rule: they *must* be surrounded by spaces. If the number of characters before the character is even (including spaces), you'll need two spaces before it, otherwise two spaces after. For example, "Symbol ‡_ means melee" has 7 characters before '‡_', so you'd write "Symbol ‡_  means melee". This is because the special character and the space are processed as a letter pair.