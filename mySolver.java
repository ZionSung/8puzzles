import java.util.*;
public class mySolver extends Solver {

    public void solve() {
        int finish = 0;
        int pc = 0; // path
        int act = 0;
        int[] eachlevelnode = new int[50];
        int eachlevelcounting = 1;

        Random rand = new Random();

        ArrayList<Integer> os; // original state
        os = getCurrentState();

        int nodeCounter = 0;
        int currentlevellevelnode = 0;
        int levelNode = 0;
        int totalLevelNode = 0;
        int getParentNode = -1;
        int firstgct = 0;

        int pathcost = 0;
        int j = 0; // counter

        Node[] n = new Node[500];
        n[nodeCounter] = new Node(os, null, null, pc);

        ArrayList<Action> moves; // data structure used for storing available moves

        while(true) {

            while (true) {

                pc++;
                // store the parent node state
                moves = getAvailableMoves(); // obtain available moves using API
                Action confirm = null;
                System.out.println("possible moves: " + moves); //

                getParentNode++;

                System.out.println("nodeCounter = " + nodeCounter);
                System.out.println("moves.size = " + moves.size());

                for (act = 0; act < moves.size(); act++) { // change the middle of the "for loop"

                    Action a = moves.get(act);// the type of available moves in the ArrayList is Action.



                        System.out.println(moves.size());
                        System.out.println("choose move: " + a); // you can use this to output what move you choose in the console
                        makeAction(a); // execute the action(a) obtained from previous statement by calling the makeAction API
                        ArrayList<Integer> pz;
                        pz = getCurrentState();

                        nodeCounter++;

                        n[nodeCounter] = new Node(pz, n[getParentNode], a, pc);

                        currentlevellevelnode++;

                        ArrayList<Action> moveback; // data structure used for storing available moves
                        moveback = getAvailableMoves(); // obtain available moves using API

                        if (isGoalState(pz)) {
                            System.out.println("Yes, it is an goal test!");
                            finish = 1;
                            break;
                        } else {

                            System.out.println("Sorry, this is not the goal test.");

                            Action mb = null;
                            if (n[nodeCounter].getAction() == a.UP) {
                                makeAction(mb.DOWN);
                            } else if (n[nodeCounter].getAction() == a.DOWN) {
                                makeAction(mb.UP);
                            } else if (n[nodeCounter].getAction() == a.LEFT) {
                                makeAction(mb.RIGHT);
                            } else {
                                makeAction(mb.LEFT);
                            }
                        }

                } // end for

                eachlevelnode[eachlevelcounting] = moves.size();
                eachlevelcounting++;

                if (finish == 1) {
                    break;
                } else {

                    pathcost = n[nodeCounter].getPathCost();
                    System.out.println("+++++++++++++++++++++++++++++++" + pathcost);


                    for( j = 1; j < pathcost; j++ ) {

                        // if (n[nodeCounter].getParent() != n[0]) {

                        /*

                        System.out.println(".........................."+nodeCounter);

                        System.out.println(n[nodeCounter].getParent().getState());

                        System.out.println("original state: "+ os);

                        System.out.println("n[0] = " + n[0].getState());
                        System.out.println("n[1] = " + n[1].getState());
                        System.out.println("n[2] = " + n[2].getState());
                        System.out.println("n[3] = " + n[3].getState());
                        System.out.println("n[4] = " + n[4].getState());
                        System.out.println("n[5] = " + n[5].getState());
                        System.out.println("n[6] = " + n[6].getState());
                        System.out.println("n[7] = " + n[7].getState());

                        System.out.println("n[1] parent: " + n[1].getParent().getState());
                        System.out.println("n[2] parent: " + n[2].getParent().getState());
                        System.out.println("n[3] parent: " + n[3].getParent().getState());
                        System.out.println("n[4] parent: " + n[4].getParent().getState());
                        System.out.println("n[5] parent: " + n[5].getParent().getState());
                        System.out.println("n[6] parent: " + n[6].getParent().getState());
                        System.out.println("n[7] parent: " + n[7].getParent().getState());


                        System.out.println("n[8] = " + n[8].getState());
                        System.out.println("n[9] = " + n[9].getState());
                        System.out.println("n[10] = " + n[10].getState());
                        System.out.println("n[11] = " + n[11].getState());
                        System.out.println("n[12] = " + n[12].getState());
                        System.out.println("n[13] = " + n[13].getState());
                        System.out.println("n[14] = " + n[14].getState());
                        System.out.println("n[15] = " + n[15].getState());


                        System.out.println("n[1] parent: " + n[1].getParent().getState());
                        System.out.println("n[2] parent: " + n[2].getParent().getState());
                        System.out.println("n[3] parent: " + n[3].getParent().getState());
                        System.out.println("n[4] parent: " + n[4].getParent().getState());
                        System.out.println("n[5] parent: " + n[5].getParent().getState());
                        System.out.println("n[6] parent: " + n[6].getParent().getState());
                        System.out.println("n[7] parent: " + n[7].getParent().getState());
                        System.out.println("n[8] parent: " + n[8].getParent().getState());
                        System.out.println("n[9] parent: " + n[9].getParent().getState());
                        System.out.println("n[10] parent: " + n[10].getParent().getState());
                        System.out.println("n[11] parent: " + n[11].getParent().getState());
                        System.out.println("n[12] parent: " + n[12].getParent().getState());
                        System.out.println("n[13] parent: " + n[13].getParent().getState());
                        System.out.println("n[14] parent: " + n[14].getParent().getState());
                        System.out.println("n[15] parent: " + n[15].getParent().getState());

                        */

                        Node addnode;
                        addnode = n[nodeCounter].getParent();

                        // Here has bug
                        for (int k = 1; k < j; k++) {
                            addnode = addnode.getParent();
                        }
                        Action backtoparent;
                        backtoparent = addnode.getAction();

                        Action mbtp = null;
                        if (backtoparent == Action.UP) {
                            makeAction(mbtp.DOWN);
                        } else if (backtoparent == Action.DOWN) {
                            makeAction(mbtp.UP);
                        } else if (backtoparent == Action.LEFT) {
                            makeAction(mbtp.RIGHT);
                        } else {
                            makeAction(mbtp.LEFT);
                        }
                        pc--;

                    }


                    int levelcounting = 1;

                    if( eachlevelnode[levelcounting] == 0){
                        Action nextnode;
                        int y = 1;

                        nextnode = n[0+y].getAction();
                        makeAction(nextnode);
                        System.out.println("=====================================");
                        System.out.println(nextnode);

                        pc++;
                        y++;
                        levelcounting++;
                    }
                    eachlevelnode[levelcounting]--;

                    Action b = n[getParentNode + 1 ].getAction();
                    makeAction(b);


                    levelNode = currentlevellevelnode;
                    totalLevelNode = currentlevellevelnode;
                    currentlevellevelnode = 0;
                }

            } // end inward while
            if( finish == 1 ){
                break;
            }
            //  print(); // this API can be used to output the puzzle in the console;
        }
    }
}

/*

import java.util.*;
public class mySolver extends Solver {

public void solve() {
Random rand = new Random();
ArrayList<Action> moves; // data structure used for storing available moves
for (int i=0;i<5;i++) {
moves = getAvailableMoves(); // obtain available moves using API
System.out.println("possible moves: " + moves); // you can use this to output all possible moves in the console
Action a = moves.get(rand.nextInt(moves.size())); // the type of available moves in the ArrayList is Action.
System.out.println("choose move: " + a); // you can use this to output what move you choose in the console
makeAction(a); // execute the action(a) obtained from previous statement by calling the makeAction API
}
print(); // this API can be used to output the puzzle in the console
}
}

*/