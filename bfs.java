import java.util.*;


public class bfs extends Solver {
    public void solve() {
        Random rand = new Random();

        ArrayList<Integer> initial_state = getCurrentState();
        int path_cost = 0;
        int ans = 0;

        // create node
        Node node = new Node( initial_state, null, null, path_cost );
        Node last_node = new Node( initial_state, null, null, path_cost );

        // create queue
        Queue<Node> frontier = new LinkedList<Node>();
        frontier.offer(node);
        System.out.println(frontier.peek().getState());
        // stateSet is a set that contains node that are already visited
        Set<ArrayList<Integer>> stateSets = new HashSet<ArrayList<Integer>>();

        // declare move
        ArrayList<Action> action;

        while(true){

            if( frontier.peek() == null ){
                ans = 0;
                break;
            }

            Node currentnode = frontier.poll();
            stateSets.add( currentnode.getState() );
            action = getAvailableMoves(currentnode.getState());
            List<Action> move = getAvailableMoves(currentnode.getState());
            for( Action a : move ){
                Node child = new Node( getNextState(currentnode.getState(), a ), currentnode, a, (currentnode.getPathCost() + 1 ));
                if( !stateSets.contains(child.getState()) ){
                    if( isGoalState(child.getState()) ){
                        ans = 1;
                        frontier.offer(child);
                        System.out.println(child.getState());
                        last_node = child;
                        break;
                    }
                    else{
                        frontier.offer(child);
                        stateSets.add(child.getState());
                    }
                    if( isGoalState(last_node.getState()))break;
                }
                if( isGoalState(last_node.getState()))break;
            }
            if( isGoalState(last_node.getState()))break;
        }

        if( ans == 1 ){
            Stack<Action> stack = new Stack<Action>();

            while( last_node != node ) {
                stack.push( last_node.getAction() );
                last_node = last_node.getParent();
            }

            while( stack.peek() != null ){
                makeAction( stack.pop() );
            }
        }


        print(); // this API can be used to output the puzzle in the console
    }

}