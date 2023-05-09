import Heuristics.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("CountingTiles depth 3: ");
//        Tester t1 = new Tester(new CountingTilesHeuristic(), new StupidHeuristic(), false);
//        t1.testStrengthMultipleGames(100, 4);
//        System.out.println("Corner depth 3: ");
//        Tester t2 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), false);
//        t2.testStrengthMultipleGames(100, 3);
//        System.out.println("Mobility depth 3: ");
//        Tester t3 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), false);
//        t2.testStrengthMultipleGames(100, 3);

//        System.out.println("CountingTiles depth 4: ");
//        Tester t1 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), true);
//        t1.testStrengthMultipleGames(100, 4);
//        System.out.println("Corner depth 4: ");
//        Tester t2 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), true);
//        t2.testStrengthMultipleGames(100, 4);
//        System.out.println("Mobility depth 4: ");
//        Tester t3 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), true);
//        t2.testStrengthMultipleGames(100, 4);

//        System.out.println("performance CountingTiles depth 3: ");
//        Tester t4 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), false);
//        t4.testPerformanceMultipleGames(100, 3);
//        System.out.println("performance Corner depth 3: ");
//        Tester t5 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), false);
//        t5.testPerformanceMultipleGames(100, 3);
//        System.out.println("performance Mobility depth 3: ");
//        Tester t6 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), false);
//        t6.testPerformanceMultipleGames(100, 3);

//        System.out.println("performance CountingTiles depth 4: ");
//        Tester t7 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), false);
//        t7.testPerformanceMultipleGames(100, 4);
//        System.out.println("performance Corner depth 4: ");
//        Tester t8 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), false);
//        t8.testPerformanceMultipleGames(100, 4);
//        System.out.println("performance Mobility depth 4: ");
//        Tester t9 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), false);
//        t9.testPerformanceMultipleGames(100, 4);

//        System.out.println("Alpha Beta performance CountingTiles depth 3: ");
//        Tester tab1 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), true);
//        tab1.testPerformanceMultipleGames(100, 3);
//        System.out.println("Alpha Beta performance Corner depth 3: ");
//        Tester tab2 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), true);
//        tab2.testPerformanceMultipleGames(100, 3);
//        System.out.println("Alpha Beta performance Mobility depth 3: ");
//        Tester tab3 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), true);
//        tab3.testPerformanceMultipleGames(100, 3);

//        System.out.println("Alpha Beta performance CountingTiles depth 4: ");
//        Tester tab4 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), true);
//        tab4.testPerformanceMultipleGames(100, 4);
//        System.out.println(" Alpha Beta performance Corner depth 4: ");
//        Tester tab5 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), true);
//        tab5.testPerformanceMultipleGames(100, 4);
//        System.out.println("Alpha Beta performance Mobility depth 4: ");
//        Tester tab6 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), true);
//        tab6.testPerformanceMultipleGames(100, 4);//
//        System.out.println("Corner vs Counting depth 3: ");
//        Tester tch1 = new Tester(new CornerHeuristic(), new CountingTilesHeuristic(), true);
//        tch1.testStrengthMultipleGames(15, 3);
//
//        System.out.println("Corner vs Counting depth 4: ");
//        Tester tch2 = new Tester(new CornerHeuristic(), new CountingTilesHeuristic(), true);
//        tch2.testStrengthMultipleGames(15, 4);

//        System.out.println("Corner vs Mobility depth 3: ");
//        Tester tch3 = new Tester(new CornerHeuristic(), new MobilityHeuristic(), true);
//        tch3.testStrengthMultipleGames(15, 4);
//
//        System.out.println("Mobility vs Counting depth 3: ");
//        Tester tch4 = new Tester(new MobilityHeuristic(), new CountingTilesHeuristic(), true);
//        tch4.testStrengthMultipleGames(15, 3);
//
//        System.out.println("Mobility vs Counting depth 4: ");
//        Tester tch5 = new Tester(new MobilityHeuristic(), new CountingTilesHeuristic(), true);
//        tch5.testStrengthMultipleGames(15, 4);
//
//        System.out.println("Changing vs Counting depth 4: ");
//        Tester tch6 = new Tester(new ChangingHeuristics(), new CountingTilesHeuristic(), true);
//        tch6.testStrengthMultipleGames(15, 4);
//
//        System.out.println("Changing vs Counting depth 3: ");
//        Tester tch8 = new Tester(new ChangingHeuristics(), new CountingTilesHeuristic(), true);
//        tch8.testStrengthMultipleGames(15, 3);
//
//        System.out.println("Corner vs Corner depth 3: ");
//        Tester tch7 = new Tester(new CornerHeuristic(), new CornerHeuristic(), true);
//        tch7.testStrengthMultipleGames(15, 3);



        System.out.println("Alpha Beta ChangingHeuristic depth 3: ");
        Tester tch1 = new Tester(new ChangingHeuristics(), new StupidHeuristic(), true);
        tch1.testStrengthMultipleGames(1, 3);

//        System.out.println("Alpha Beta  ChangingHeuristic depth 4: ");
//        Tester tch2 = new Tester(new ChangingHeuristics(), new StupidHeuristic(), true);
//        tch2.testStrengthMultipleGames(100, 4);




    }
}
