# Guru99_eCommerce
Guru99 Live Selenium Webdriver Testing Project

📝 Project Summary:

This is a demo project provided by Guru99. It simulates Selenium WebDriver test cases for a demo eCommerce website every 24hs for 11 days. Uploading each test case to GitHub as part of my portfolio as a tester.

🕒 Day 1:

Test Scenario: Verify item in Mobile list page can be sorted by 'Name'

Test Case: Sort items by name

Test Steps:

Go to http://live.techpanda.org/
Verify Title of the page
Click on 'MOBILE' meny
Verify Title of the page
In the list of all mobile, select 'SORT BY' dropdown as 'name'
Verify all products are sorted by name
Validation requirements:

Text 'THIS IS DEMO SITE' shown in home page
Tittle 'MOBILE' is shown on mobile list page
All 3 products sorted by name

Expected Result:

Items are sorted by name

Additional info: The client has requested you to use WebDriver (Firefox Driver) for the project.


🕒 Day 2:

Test Scenario: Verify that cost of product in list page and details page are equal

Test Case: Price is the same in two different pages

Test Steps:

Go to http://live.techpanda.org/
Click on 'MOBILE' meny
In the list of all mobile, read the cost of Sony Xperia mobile. Note this value
Click on Sony Xperia mobile
Read the Sony Xperia mobile from detail page
Compare value in step 3 & 5

Validation requirements:

Price on step 3 & 5 are the same

Expected Result:

Product value in list and tealis page should be equal ($100)