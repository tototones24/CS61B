package jump61;

import static jump61.Side.*;
import static jump61.Square.square;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

/** A Jump61 board state that may be modified.
 *  @author Antonio Contreras
 */
class MutableBoard extends Board {

    /** An N x N board in initial configuration. */
    MutableBoard(int N) {
        size = N + 1;
        _white = N * N;
        _red = 0;
        _blue = 0;
        mboard = new Square[size][size];
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                mboard[row][col] = Square.square(WHITE, 1);
            }
        }
        _history = new Stack<Board>();
    }

    /** A board whose initial contents are copied from BOARD0, but whose
     *  undo history is clear. */
    MutableBoard(Board board0) {
        this(board0.size());
        this.copy(board0);
    }

    @Override
    void clear(int N) {
        size = N + 1;
        _white = N * N;
        _red = 0;
        _blue = 0;
        mboard = new Square[size][size];
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                mboard[row][col] = Square.square(WHITE, 1);
            }
        }
        _history = new Stack<Board>();
        announce();
    }

    @Override
    void copy(Board board) {
        for (int row = 1; row < board.size(); row++) {
            for (int col = 1; col < board.size(); col++) {
                Square board0Square = board.get(row, col);
                Side player = board0Square.getSide();
                int spots = board0Square.getSpots();
                mboard[row][col] = Square.square(player, spots);
            }
        }
        _red = numOfSide(RED);
        _blue = numOfSide(BLUE);
        _white = numOfSide(WHITE);
    }

    /** Copy the contents of BOARD into me, without modifying my undo
     *  history.  Assumes BOARD and I have the same size. */
    private void internalCopy(Board board) {
        for (int row = 1; row <= board.size(); row++) {
            for (int col = 1; col <= board.size(); col++) {
                Square board0Square = board.get(row, col);
                Side player = board0Square.getSide();
                int spots = board0Square.getSpots();
                mboard[row][col] = Square.square(player, spots);
            }
        }
        _red = numOfSide(RED);
        _blue = numOfSide(BLUE);
        _white = numOfSide(WHITE);
    }

    @Override
    int size() {
        return mboard.length - 1;
    }

    @Override
    Square get(int n) {
        int ro = row(n);
        int co = col(n);
        return mboard[ro][co];
    }

    @Override
    int numOfSide(Side side) {
        int numberOfSquares = 0;
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                Square finalSq = get(sqNum(row, col));
                Side colorside = finalSq.getSide();
                if (colorside == side) {
                    numberOfSquares += 1;
                }
            }
        }
        return numberOfSquares;
    }

    @Override
    int numPieces() {
        int numOfSpots = 0;
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                numOfSpots += mboard[row][col].getSpots();
            }
        }
        return numOfSpots;
    }

    @Override
    void addSpot(Side player, int r, int c) {
        if (isLegal(player, r, c)) {
            markUndo();
            explosion(player, r, c);
        }
        announce();
    }

    /** The the actuall jumping of the spot is done here.
     * @param PLAYER
     * @param R
     * @param C
     */
    void explosion(Side player, int r, int c) {
        colorBalancing(player, r, c);
        int spots = mboard[r][c].getSpots();
        Square square = Square.square(player, spots + 1);
        mboard[r][c] = square;
        if (mboard[r][c].getSpots() > neighbors(sqNum(r, c))
            && numOfSide(player) != (size() * size())) {
            List<Integer> neighs = allNeighbors(r, c);
            Square newsquare = Square.square(player, 1);
            mboard[r][c] = newsquare;
            for (int neighbor : neighs) {
                int ro = row(neighbor);
                int co = col(neighbor);
                explosion(player, ro, co);
            }
        }
    }

    /**
     * Determines the total number of squares of each color that
     * there is the board.
     * @param player current player playing
     * @param r the row
     * @param c the column
     */
    private void colorBalancing(Side player, int r, int c) {
        if (mboard[r][c].getSide() == WHITE) {
            if (player == RED) {
                _red += 1;
            } else {
                _blue += 1;
            }
        }
        if (player != mboard[r][c].getSide()) {
            if (mboard[r][c].getSide() == RED) {
                _red -= 1;
                if (player == RED) {
                    _red += 1;
                }
                if (player == BLUE) {
                    _blue += 1;
                }
            }
            if (mboard[r][c].getSide() == BLUE) {
                _blue -= 1;
                if (player == RED) {
                    _red += 1;
                }
                if (player == BLUE) {
                    _blue += 1;
                }
            }
        }
    }

    /**
     * Returns the neighbors around R and C.
     * @param r the row
     * @param c the col
     * @return return the neibors
     */
    private List<Integer> allNeighbors(int r, int c) {
        List<Integer> squareNums = new ArrayList<Integer>();
        if ((r - 1) >= 1) {
            int sqNumber = sqNum(r - 1, c);
            squareNums.add(sqNumber);
        }
        if ((r + 1) <= size()) {
            int sqNumber = sqNum(r + 1, c);
            squareNums.add(sqNumber);
        }
        if ((c - 1) >= 1) {
            int sqNumber = sqNum(r, c - 1);
            squareNums.add(sqNumber);
        }
        if ((c + 1) <= size()) {
            int sqNumber = sqNum(r, c + 1);
            squareNums.add(sqNumber);
        }
        return squareNums;
    }

    @Override
    void addSpot(Side player, int n) {
        addSpot(player, row(n), col(n));
        announce();
    }

    @Override
    void set(int r, int c, int num, Side player) {
        internalSet(sqNum(r, c), square(player, num));
    }

    @Override
    void set(int n, int num, Side player) {
        internalSet(n, square(player, num));
        announce();
    }

    @Override
    void undo() {
        if (!_history.empty()) {
            this.copy(_history.pop());
        }
    }

    /** Record the beginning of a move in the undo history. */
    private void markUndo() {
        Board copyOriginal = new MutableBoard(this);
        _history.push(copyOriginal);
    }

    /** Set the contents of the square with index IND to SQ. Update counts
     *  of numbers of squares of each color.  */
    private void internalSet(int ind, Square sq) {
        int roW = row(ind);
        int coL = col(ind);
        Side player = mboard[roW][coL].getSide();
        Side squareColor = sq.getSide();
        if (squareColor == BLUE) {
            _blue += 1;
        }
        if (squareColor == RED) {
            _red += 1;
        }
        if (squareColor == WHITE) {
            _white += 1;
        }
        if (player == BLUE) {
            _blue -= 1;
        }
        if (player == RED) {
            _red -= 1;
        }
        if (player == WHITE) {
            _white -= 1;
        }
        mboard[roW][coL] = sq;
    }

    /** Notify all Observers of a change. */
    private void announce() {
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MutableBoard)) {
            return obj.equals(this);
        } else {
            MutableBoard compBoard = (MutableBoard) obj;
            if (compBoard.size() != this.size()) {
                return false;
            }
            if (compBoard.numOfSide(RED) != this.numOfSide(RED)
                || compBoard.numOfSide(BLUE) != this.numOfSide(BLUE)
                    || compBoard.numOfSide(WHITE) != this.numOfSide(WHITE)) {
                return false;
            }
            for (int r = 1; r < size; r++) {
                for (int c = 1; c < size; c++) {
                    int rowz = row(r);
                    int colz = col(c);
                    int numberSq = sqNum(rowz, colz);
                    if (!mboard[r][c].equals(this.get(numberSq))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }

    /** This will be the representation of the mutableboard. */
    private Square[][] mboard;

    /** Returns the size of one side of the array. */
    private int size;

    /** Counts the number of white squares in the board. */
    private int _white;

    /** Counts the number red squares in the board. */
    private int _red;

    /** Counts the total number of blue squares in the board. */
    private int _blue;

    /** The history of the moves. */
    private Stack<Board> _history;

    /** The number of times a move is done. */
    private int numOfMoves;
}

