/*

Since very long time Tom and Jerry have been fighting with each other for a piece of Cheese. So finally you came to rescue and decided that the result of the fight will be decided by a mathematical game , in which you will write a number N . Tom and Jerry will play the game alternatively and each of them would subtract a number n [n< N] such that N%n=0. 
The game is repeated turn by turn until the one,who now cannot make a further move looses the game. 
The game begins with Tom playing first move.It is well understood that both of them will make moves in optimal way.You are to determine who wins the game.

Input

The first line of input contains a single integer T denoting the number of test cases.
Then T test cases follow. The first line of each test case consists of N the number.

Output

Print 1 if Tom wins and Print 0 if Jerry wins in a separate line.

Constraints

1<= T<=100 

1 <= N <= 10^6

Sample Input

2 
2 
4

Sample Output

1 
1



-------------------------------------------------------------------------------------------------
Solution:

With little effort, you can figure out that:
If N = 1, the first player looses.
If N = 2, the first player wins.

Let's say that the initial value of N is even. Then, the first player can play two types of moves:
1. He can subtract 1 since 1 is a divisor of every natural number.
2. He can subtract any divisor of N other than 1 and N itself.

Notice one thing here that if he subtracts 1, the other player gets an odd N. Now, the divisor of any odd number must be odd. So the other player is bound to subtract an odd number, whether 1 or any other odd number. In both the cases, after subtraction, an even number is obtained (since an odd number subtracted from another odd number gives an even number).

The player who started will therefore prefer to "subtract 1" as his every move because he then gets back another even value of N for his next move until N becomes 2 for his turn and he wins.

Now, think about the case when N is initially odd. In this case, the first player is bound to subtract an odd number resulting into an even value of N for the second player. With the previous logic, we can say that the second player, if plays optimally (i.e. chooses 1 to subtract as every move), will win.

Notice here that subtracting 1 may not be the only way out to win the game for the player who has got an even N for his next move. There may be other ways too which could lead him to win quicker. For instance, if a player gets N=12, he'd subtract n=3 rather than n=1 so that the other player gets a smaller odd number as N. This may lead to a quicker victory.

In general, if the loosing player tries his best to delay the outcome, the player who gets an even N should subtract the largest odd divisor of N in each of his moves to win as quickly as possible.

Besides that, if the loosing player wants to delay the outcome of the game as much as possible, he should subtract n=1 from N in each of his moves.

 
*/


package Mathematical_Concept;


public class Tom_and_Jerry {

	public static void main(String[] args) {
		int n = 10;
		System.out.println((n-1)%2);
	}

}
