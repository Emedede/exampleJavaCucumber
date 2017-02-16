Feature: Complete Checkout Process

@all
 Scenario: Go to TicketWeb Events list, select an event and complete checkout flow  
    Given Open events TW page
    When Select event 
    Then I validate title and URL
#   
#    | event       |
#    | event       |