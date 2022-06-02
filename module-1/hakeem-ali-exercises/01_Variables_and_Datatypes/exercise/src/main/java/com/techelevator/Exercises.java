package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;

		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;

		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberOfRaccoons = 3;
		int numberOfRaccoonsWentHome = 2;

		int numberOfRaccoonsLeft = numberOfRaccoons - numberOfRaccoonsWentHome;


        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;

		int numberOfLessBeesThanFlowers = numberOfFlowers - numberOfBees;


        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numberOfPigeonsInitiallyEating = 1;
		int numberOfPigeonsArrivedToEat = 1;

		int numberOfPigeonsEating = numberOfPigeonsInitiallyEating + numberOfPigeonsArrivedToEat;


        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numberOfOwlsInitiallySittingOnFence = 3;
		int numberOfOwlsJoined = 2;

		int numberOfOwlsSittingOnFence = numberOfOwlsInitiallySittingOnFence + numberOfOwlsJoined;


        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int numberOfBeaversInitiallyWorking = 2;
		int numberOfBeaversThatWentSwimming = 1;

		int numberOfBeaversCurrentlyWorking = numberOfBeaversInitiallyWorking - numberOfBeaversThatWentSwimming;


        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int numberOfToucansInitiallySittingOnTree = 2;
		int numberOfToucansJoined = 1;

		int numberOfToucansCurrentlySittingOnTree = numberOfToucansInitiallySittingOnTree + numberOfToucansJoined;


        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;

		int numberOfMoreSquirrelsThanNuts = numberOfSquirrels - numberOfNuts;


        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;

		double totalMoneyFound = quarter + dime + (2 * nickel);


        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int briersMuffinsMade = 18;
		int macAdamsMuffinsMade = 20;
		int flanneryMuffinsMade = 17;

		int totalMuffinsMade = briersMuffinsMade + macAdamsMuffinsMade + flanneryMuffinsMade;


        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double costOfYoyo = 0.24;
		double costOfWhistle = 0.14;

		double totalMoneySpent = costOfYoyo + costOfWhistle;


        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int numberOfLargeMarshmallows = 8;
		int numberOfMiniMarshmallows = 10;

		int totalMarshmallowsUsed = numberOfLargeMarshmallows + numberOfMiniMarshmallows;


        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int hiltsHouseSnowInches = 29;
		int brecknockSchoolSnowInches = 17;

		int differenceSnowInches = hiltsHouseSnowInches - brecknockSchoolSnowInches;


        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		double hiltMoney = 10.00;
		double costOfToyTruck = 3.00;
		double costOfPencilCase = 2.00;

		double moneyLeftover = hiltMoney - (costOfToyTruck + costOfPencilCase);

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int marblesInitiallyCollected = 16;
		int marblesLost = 7;

		int marblesCurrentlyCollected = marblesInitiallyCollected - marblesLost;


        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int seashellsInitiallyOwned = 19;
		int seashellsGoal = 25;

		int seashellsNeeded = seashellsGoal - seashellsInitiallyOwned;


        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int numberOfTotalBalloons = 17;
		int numberOfRedBalloons = 8;

		int numberOfGreenBalloons = numberOfTotalBalloons - numberOfRedBalloons;


        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int numberOfBooksInitiallyOnShelf = 38;
		int numberOfBooksPutOnShelf = 10;

		int numberOfBooksOnShelf = numberOfBooksInitiallyOnShelf + numberOfBooksPutOnShelf;


        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numberOfLegsOneBee = 6;
		int numberOfTotalBees = 8;

		int numberOfTotalLegs = numberOfTotalBees * numberOfLegsOneBee;


        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costOfIceCreamCone = 0.99;
		int numberOfIceCreamCones = 2;

		double costOfIceCreamCones = numberOfIceCreamCones * costOfIceCreamCone;


        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int numberOfRocksGoal = 125;
		int numberOfRocksOwned = 64;

		int numberOfRocksNeeded = numberOfRocksGoal - numberOfRocksOwned;


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int numberOfHiltsInitialMarbles = 38;
		int numberOfHiltsMarblesLost = 15;

		int numberOfHiltsMarbles = numberOfHiltsInitialMarbles - numberOfHiltsMarblesLost;


        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int numberOfMilesConcertAway = 78;
		int numberOfMilesDriven = 32;

		int numberOfMilesLeftToConcert = numberOfMilesConcertAway - numberOfMilesDriven;


        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int hiltShovelingSnowSatMorningMinutes = 90;
		int hiltShovelingSnowSatAfternoonMinutes = 45;

		int totalHiltShovelingSnowMinutes = hiltShovelingSnowSatMorningMinutes + hiltShovelingSnowSatAfternoonMinutes;


        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int numberOfHiltBoughtHotDogs = 6;
		double costOfHotDog = 0.50;

		double costOfTotalHotDogs = numberOfHiltBoughtHotDogs * costOfHotDog;


        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		double hiltMoneyOwned = 0.50;
		double costOfOnePencil = 0.07;

		int numberOfPurchasablePencils = (int)(hiltMoneyOwned / costOfOnePencil);


        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int numberOfHiltSeenButterflies = 33;
		int numberOfOrangeButterflies = 20;

		int numberOfRedButterflies = numberOfHiltSeenButterflies - numberOfOrangeButterflies;


        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double amountKatePaid = 1.00;
		double costOfKateCandy = 0.54;

		double changeKateReceived = amountKatePaid - costOfKateCandy;


        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int numberOfTreesMarkBackyard = 13;
		int numberOfTreesMarkPlants = 12;

		int numberOfTotalMarkTrees = numberOfTreesMarkBackyard + numberOfTreesMarkPlants;


        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int oneDayInHours = 24;
		int numberOfDaysToJoyGrandma = 2;

		int numberOfHoursToJoyGrandma = oneDayInHours * numberOfDaysToJoyGrandma;


        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numberOfKimCousins = 4;
		int numberOfPiecesOfGumPerCousin = 5;

		int numberOfPiecesOfGumNeeded = numberOfKimCousins * numberOfPiecesOfGumPerCousin;


        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double amountOfMoneyDanHas = 3.00;
		double costOfDanCandyBar = 1.00;

		double amountOfMoneyDanLeftover = amountOfMoneyDanHas - costOfDanCandyBar;


        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numberOfBoatsOnLake = 5;
		int numberOfPeopleInEachBoat = 3;

		int numberOfTotalPeopleOnBoatsOnTheLake = numberOfBoatsOnLake * numberOfPeopleInEachBoat;


        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int numberOfEllenInitialLegos = 380;
		int numberOfLegosEllenLost = 57;

		int numberOfEllenCurrentLegos = numberOfEllenInitialLegos - numberOfLegosEllenLost;


        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int numberOfMuffinsArthurBaked = 35;
		int numberOfMuffinsBakedGoal = 83;

		int numberOfMuffinsLeftToGoal = numberOfMuffinsBakedGoal - numberOfMuffinsArthurBaked;


        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int numberOfWillyCrayons = 1400;
		int numberOfLucyCrayons = 290;

		int numberOfWillyCrayonsMoreThanLucyCrayons= numberOfWillyCrayons - numberOfLucyCrayons;


        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int numberOfStickersOnOnePage = 10;
		int numberOfPagesOfStickers = 22;

		int numberOfTotalStickers = numberOfStickersOnOnePage * numberOfPagesOfStickers;


        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double numberOfTotalCupcakesToShare = 100;
		double numberOfChildrenForCupcakeSharing = 8;

		double numberOfCupcakesForEachChild = numberOfTotalCupcakesToShare / numberOfChildrenForCupcakeSharing;


        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int numberOfGingerbreadCookiesMade = 47;
		int numberOfGingerbreadCookiesPerJar = 6;

		int numberOfCookiesNotPlacedInJar = numberOfGingerbreadCookiesMade % numberOfGingerbreadCookiesPerJar;


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int numberOfCroissantsMade = 59;
		int numberOfNeighborsToShareCroissants = 8;

		int numberOfCroissantsNotShared = numberOfCroissantsMade % numberOfNeighborsToShareCroissants;


        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int numberOfCookiesPerTray = 12;
		int numberOfTotalCookiesMade = 276;

		int numberOfTraysNeeded = numberOfTotalCookiesMade / numberOfCookiesPerTray;


        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int numberOfBiteSizedPretzelsMade = 480;
		int numberOfBiteSizedPretzelsInOneServing = 12;

		int numberOfServingsOfBitSizedPretzelsMade = numberOfBiteSizedPretzelsMade / numberOfBiteSizedPretzelsInOneServing;


        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int numberOfLemonCupcakesBaked = 53;
		int numberOfLemonCupcakesLeftAtHome = 2;
		int numberOfLemonCupcakesPerBox = 3;

		int numberOfLemonCupcakesBoxesGivenAway = (numberOfLemonCupcakesBaked - numberOfLemonCupcakesLeftAtHome) / numberOfLemonCupcakesPerBox;


        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int numberOfCarrotSticksSuziesMomMade = 74;
		int numberOfPeopleServedCarrotSticks = 12;

		int numberOfUneatenCarrotSticks = numberOfCarrotSticksSuziesMomMade % numberOfPeopleServedCarrotSticks;


        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int numberOfTotalTeddyBears = 98;
		int numberOfTeddyBearsPerShelf = 7;

		int numberOfShelvesFilledWithTeddyBears = numberOfTotalTeddyBears / numberOfTeddyBearsPerShelf;


        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int numberOfTotalFamilyPictures = 480;
		int numberOfFamilyPicturesPerAlbum = 20;

		int numberOfTotalFamilyPictureAlbums = numberOfTotalFamilyPictures / numberOfFamilyPicturesPerAlbum;


        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int numberOfTotalTradingCards = 94;
		int numberOfTradingCardsInABox = 8;

		int numberOfTradingCardBoxesFilled = numberOfTotalTradingCards / numberOfTradingCardsInABox;
		int numberOfTradingCardsLeftover = numberOfTotalTradingCards % numberOfTradingCardsInABox;


        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int numberOfTotalBooks = 210;
		int numberOfBookshelves = 10;

		int numberOfBooksOnEachShelf = numberOfTotalBooks / numberOfBookshelves;


        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double numberOfCroissantsCristinaBaked = 17.0;
		double numberOfCristinaGuests = 7.0;

		double numberOfCroissantsPerGuest = numberOfCroissantsCristinaBaked / numberOfCristinaGuests;


	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
	    Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
	    */
		double billFeetHourlyRate = 168 / 2.15;
		double jillFeetHourlyRate = 168 / 1.90;
		double togetherFeetHourlyRate = billFeetHourlyRate + jillFeetHourlyRate;
		int numberOfFeetToBePainted = 168 * 5;

		double hoursToPaintWalls = numberOfFeetToBePainted / togetherFeetHourlyRate;


	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName = "Grace";
		String lastName = "Hopper";
		String middleInitial = "B";
		String fullName = lastName + ", " + firstName + " " + middleInitial + ".";


	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		double distanceBetweenNyAndChi = 800;
		double distanceTrainTraveled = 537;

		int percentageOfTripCompleted = (int)((distanceTrainTraveled / distanceBetweenNyAndChi) * 100);

	}

}
