import java.util.*;

public class TicTacToe {

    private int n;
    private Set<String> seen;

    public TicTacToe(int n) {
        this.n = n;
        this.seen = new HashSet<>();
    }

    void reportFound(String sol) {
        System.out.printf("\"%s\"\n", sol);
    }

    private boolean finished(short b[][]) {
        int D=0, RD=0, C=0;
        for (int i=0;i<n;++i) {
            int V=0, H=0;
            for (int j=0;j<n;++j) {
                V += b[j][i]; H += b[i][j];
                C += Math.abs(b[i][j]);
            }
            if (Math.abs(V)==n || Math.abs(H)==n)
                return true;
            D += b[i][i];
            RD += b[i][n-i-1];
        }
        return C==n*n || Math.abs(D)==n || Math.abs(RD)==n;
    }
    private String asString(short b[][]) {
        char[] c = {'x', ' ', 'o'};
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                sb.append(c[b[i][j]+1]);
            }
        }
        return sb.toString();
    }
    private void move(short b[][], short turn) {
        if (finished(b)) {
            String foundRep = asString(b);
            if (seen.add(foundRep)) // report found if new
                reportFound(foundRep);
        } else {
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (b[i][j]==0) {
                        b[i][j]=turn;
                        move(b, (short) -turn);
                        b[i][j]=0;
                    }
                }
            }
        }
    }

    public void run() {
        move(new short[n][n], (short) 1);
    }
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.run();
    }
}
