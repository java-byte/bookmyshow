# bookmyshow

## Requirement
Implement a movie ticket booking application for a theatre. Refer to the following details:

- A theatre has screen that run shows fro different movies. Each show has a particular movie, start time, duration and is played in a particular screen in the theatre. Each screen has an attachment of seats that can be booked by user.
- Assume all users are registered, authenticated and logged in to the application.
- Once a user selects a particular show to book ticket for, a **UserBookingSession** starts. Within this UserBookingSession, a user will be able to get the available seats for the show and select the seat he wishes to book. Its is **good to have** for the application to have limits on the number of seats a user can book in a ticket.
- Once a user have selected a group of seats, these seats should become TEMPORARY_UNAVAILABLE to all other users.
- The user will then proceeds to make payment which can either be SUCCESS or FAILURE.
- If payment FAILED, user can retry payment for maximum number of times. Beyond maximum retries, the seats are made AVAILABLE for other users.
- If Payments SUCCEEDS, ticket or booking confirmation is generated and made available to the user. The **UserBookingSession** is closed and the seats are made PERMANENTLY_UNAVAILABLE.
- A user can also explicitly close the **UserBookingSession** after selecting seats and before making payment. In this case, the seats selected are make AVAILABLE once again.

## Problem
Demonstrate the following scenario:
2 concurrent users U1, U2 in the application. The user can retrieve available shows and select one show.

#### Case 1:
1. Say U1 and U2 select same show.
2. U1 requests for and gets all available seats for this show.
3. U1 selects group of seats and proceeds to pay.
4. U2 requests for and gets all available seats for this show. U2 should not see the seats selected by U1 as AVAILABLE.
5. Payment succeeded for the U1.
6. U1 receives ticket with seats confirmed.

#### Case 2:
1. Say U1 and U2 select same show.
2. U1 and U2 requests for and gets all available seats for this show.
3. U1 selects group of seats.
4. U1 proceeds to pay.
5. U2 requests for and gets all Available Seats for this show. U2 should NOT see the seats selected by U1 as AVAILABLE.
6. Payment failed for U1. Assume maximum retries as zero just for the demo. Also show in another scenario where U1’s UserBookingSession is explicitly closed by U1 before payment is completed.
7. U2 again requests for and gets all Available Seats for this show. U2 should now see the seats previously selected by U1 as AVAILABLE.

#### Case 3:
1. Say U1 and U2 select same show.
2. U1 and U2 request for and get all Available Seats for this show.
3. U1 select group of seats and proceeds to pay.
4. U2 selects overlapping group of seats and proceeds to pay. U2 should be notified that “one or more of the selected seats are not available at this moment”.

### Bonus:

Have a configurable timeout for a UserBookingSession. Show that if User selects and Payment is not completed by timeout, then the UserBookingSession is closed and the seats selected are made AVAILABLE.
Expectations
- Create the sample data yourself. You can put it into a file, test case or main driver program itself.
- Code should be demo-able. Either by using a main driver program or test cases.
- Code should be modular. Code should have basic OO design. Please do not jam in responsibilities of one class into another.
- Code should be extensible. Wherever applicable, use interfaces and contracts between different methods. It should be easy to add/remove functionality without re-writing entire codebase.
- Code should handle edge cases properly and fail gracefully.
- Code should be legible, readable and DRY

### Guidelines

- Use of DB not expected. You can store data in memory.
- Please discuss the solution with an interviewer
- Please do not access internet for anything EXCEPT syntax
- You are free to use the language of your choice
- All code should be your own
- Please focus on the Bonus questions only after ensuring the required features are complete and demoable.

