Feature:  Verify the adactin hotel login page

Scenario: Verify using the valid credential 

Given User enters to the Adactin hotel page

When User enter "Rakeshg6199" and "Rakesh123" 

And User clicks the login button

Then User shoud see the "Search Hotel" text

Scenario: Search for hotels

Given User sees "Search Hotel " text

When User selects "Melbourne" location

And User selects "Hotel Sunshine" hotel

And User selects "Double" room

And User selects "4 - Four" no of rooms

And Users enters "16/04/2023" check in date

And Users enters "19/04/2023" check out date

And Users selects "3 - Three" nos of adults

And User Selects "3 - Three" nos of childrens

And User clicks Search button

Then User should see "Select Hotel " text

