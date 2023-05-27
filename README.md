# Guru99_eCommerce
Guru99 Live Selenium Webdriver Testing Project

📝 Project Summary:

This is a demo project provided by Guru99. It simulates Selenium WebDriver test cases for a demo eCommerce website every 24hs for 11 days. Uploading each test case to GitHub as part of my portfolio as a tester.

💼 Tasks:

Each daily task is uploaded in the tasks folder as a .png file

💼 Evidence:

While not required for the project, screenshot evidence is included in the evidence folder, sorted by day

-----

🕒 Day 1:

Test Scenario:
- Verify item in Mobile list page can be sorted by 'Name'

Test Steps:

1. Go to http://live.techpanda.org/
2. Verify Title of the page
3. Click on 'MOBILE' meny
4. Verify Title of the page
5. In the list of all mobile, select 'SORT BY' dropdown as 'name'
6. Verify all products are sorted by name


Validation requirements:
- Text 'THIS IS DEMO SITE' shown in home page
- Tittle 'MOBILE' is shown on mobile list page
- All 3 products sorted by name

Additional info:
- The client has requested you to use WebDriver (Firefox Driver) for the project.

-----

🕒 Day 2:

Test Scenario:
- Verify that cost of product in list page and details page are equal


Test Steps:
1. Go to http://live.techpanda.org/
2. Click on 'MOBILE' menu
3. In the list of all mobile, read the cost of Sony Xperia mobile. Note this value
4. Click on Sony Xperia mobile
5. Read the Sony Xperia mobile from detail page
6. Compare value in step 3 & 5

Validation requirements:
- Price on step 3 & 5 are the same
- Product value in list and tealis page should be equal ($100)

-----

🕒 Day 3:

Test Scenario:
- Verify that you cannot add more product in cart than the product availeable in store

Test Steps:
1. Go to http://live.techpanda.org/
2. Click on 'MOBILE' menu
3. In the list of all mobile, click on 'ADD TO CART' for Sony Xperia mobile
4. Change 'QTY' value to 1000 and click 'UPDATE' button
5. Verify error message
6. Then click on 'EMPTY CART' link in the footer of list of all mobiles
7. Verify cart is empty

Validation requirements:
1. On clicking update button an error is shown: 'The requested quantity for "Sony Xperia" is not available'
2. On clicking empty cart button, a message 'SHOPPING CART IS EMPTY' is shown

