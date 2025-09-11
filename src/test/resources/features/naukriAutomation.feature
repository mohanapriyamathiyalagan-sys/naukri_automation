Feature: Naukri complete Functionality

Scenario: Login and update resume in Naukri profile
  Given user is on Naukri login page
When user logs in with email and password
And user closes chatbot overlay if present
And user navigates to profile page
And user uploads resume "C:\\Users\\mohan\\Downloads\\Mohanapriya Mathiyalagan_5yrs_9months.pdf"
Then profile should be updated successfully