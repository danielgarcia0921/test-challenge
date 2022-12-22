# test-challenge
Repo for test challenges

- WARNING: If you get ChromeDriver error, then follow these steps
- Check your Chrome version, and download appropriate ChromeDriver for that version (bundled with this project is v. 108 THIS MEANS YOU NEED CHROME VERSION 108 FOR THIS REPO TO WORK OUT OF THE BOX!!!)
- Once you download a new ChromeDriver (if necessary), delete any old drivers and place in in your src/main/resources folder
- Open up a terminal on src/main/resources and run the following command: xattr -d com.apple.quarantine chromedriver  && spctl --add --label 'Approved' chromedriver
- Run the test



BEFORE RUNNING TESTS:

Go to the AssertStrings folder and fill the username and password strings in with your credentials :)
