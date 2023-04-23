import Heuristics.CornerHeuristic;
import Heuristics.CountingTilesHeuristic;
import Heuristics.IdiotHeuristic;
import Heuristics.MobilityHeuristic;

public class Main {
    public static void main(String[] args) {
//
//        System.out.println("CountingTiles depth 4: ");
//        Tester t1 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), false);
//        t1.testStrengthMultipleGames(100, 4);
//        System.out.println("Corner depth 4: ");
//        Tester t2 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), false);
//        t2.testStrengthMultipleGames(100, 4);
//        System.out.println("Mobility depth 4: ");
//        Tester t3 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), false);
//        t2.testStrengthMultipleGames(100, 4);

        System.out.println("performance CountingTiles depth 3: ");
        Tester t4 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), false);
        t4.testPerformanceMultipleGames(100, 3);
        System.out.println("performance Corner depth 3: ");
        Tester t5 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), false);
        t5.testPerformanceMultipleGames(100, 3);
        System.out.println("performance Mobility depth 3: ");
        Tester t6 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), false);
        t6.testPerformanceMultipleGames(100, 3);

//        System.out.println("performance CountingTiles depth 4: ");
//        Tester t7 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), false);
//        t7.testPerformanceMultipleGames(100, 4);
//        System.out.println("performance Corner depth 4: ");
//        Tester t8 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), false);
//        t8.testPerformanceMultipleGames(100, 4);
//        System.out.println("performance Mobility depth 4: ");
//        Tester t9 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), false);
//        t9.testPerformanceMultipleGames(100, 4);

        System.out.println("Alpha Beta performance CountingTiles depth 3: ");
        Tester tab1 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), true);
        tab1.testPerformanceMultipleGames(100, 3);
        System.out.println("Alpha Beta performance Corner depth 3: ");
        Tester tab2 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), true);
        tab2.testPerformanceMultipleGames(100, 3);
        System.out.println("Alpha Beta performance Mobility depth 3: ");
        Tester tab3 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), true);
        tab3.testPerformanceMultipleGames(100, 3);

//        System.out.println("Alpha Beta performance CountingTiles depth 4: ");
//        Tester tab4 = new Tester(new CountingTilesHeuristic(), new IdiotHeuristic(), true);
//        tab4.testPerformanceMultipleGames(100, 4);
//        System.out.println(" Alpha Beta performance Corner depth 4: ");
//        Tester tab5 = new Tester(new CornerHeuristic(), new IdiotHeuristic(), true);
//        tab5.testPerformanceMultipleGames(100, 4);
//        System.out.println("Alpha Beta performance Mobility depth 4: ");
//        Tester tab6 = new Tester(new MobilityHeuristic(), new IdiotHeuristic(), true);
//        tab6.testPerformanceMultipleGames(100, 4);
//


    }
}
