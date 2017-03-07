package encryption;

import java.util.Arrays;
import java.util.logging.Logger;

public class AES {

    private final static Logger LOGGER = Logger.getLogger(AES.class.getName());

    private static final int NUMBER_ROUNDS = 10;
    private static final int[][] KEY = {
            {
                    0x2b, 0x28, 0xab, 0x09
            },
            {
                    0x7e, 0xae, 0xf7, 0xcf
            },
            {
                    0x15, 0xd2, 0x15, 0x4f
            },
            {
                    0x16, 0xa6, 0x88, 0x3c
            }
    };
    private static final int[][] S_BOX = {
            {0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76},
            {0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0},
            {0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15},
            {0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75},
            {0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84},
            {0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf},
            {0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8},
            {0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2},
            {0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73},
            {0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb},
            {0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79},
            {0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08},
            {0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a},
            {0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e},
            {0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf},
            {0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16}
    };
    private static final int LEFT_MASK = 0xF0;
    private static final int RIGHT_MASK = 0x0F;

    private static final String[][] MCT = {
            {"02", "03", "01", "01"},
            {"01", "02", "03", "01"},
            {"01", "01", "02", "03"},
            {"03", "01", "01", "02"}
    };

    // Prevents instantiation
    private AES() {
    }

    public static String encrypt(String plaintext) {
        LOGGER.info("Entered plaintext: |" + plaintext + "|");
        byte[] bytes = plaintext.getBytes();
        LOGGER.info("Plaintext as ASCII values: " + Arrays.toString(bytes));
        int[][] stateArray = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                stateArray[j][i] = bytes[4 * i + j];
            }
        }
        LOGGER.info("Plaintext as block: " + Arrays.deepToString(stateArray));

        encrypt(stateArray);

        byte[] resultBytes = new byte[bytes.length];
        for (int i = 0; i < stateArray.length; i++) {
            for (int j = 0; j < stateArray[i].length; j++) {
                resultBytes[4 * i + j] = (byte) stateArray[i][j];
            }
        }

        String ciphertext = new String(resultBytes);

        LOGGER.info("Encrypted text: " + ciphertext);

        return ciphertext;
    }

    private static int[][] encrypt(int[][] stateArray) {

        int[][] key = KEY;
        stateArray = addRoundKey(stateArray, key);

        for (int i = 1; i <= NUMBER_ROUNDS; i++) {
            LOGGER.info("Beginning round: " + (i));
            key = keyExpansion(key, i);
            LOGGER.info("Before sub : " + i + "---" + Arrays.deepToString(stateArray));
            stateArray = substituteBytes(stateArray);
            LOGGER.info("Before Shift : " + i + "---" + Arrays.deepToString(stateArray));
            stateArray = shiftRowsLeft(stateArray);
            if (i < NUMBER_ROUNDS) {
                LOGGER.info("Before mix at round: " + i + "--" + Arrays.deepToString(stateArray));
                stateArray = mixColumns(stateArray);
            }
            LOGGER.info("Before Round : " + i + "---" + Arrays.deepToString(stateArray));

            stateArray = addRoundKey(stateArray, key);
        }

        LOGGER.info("Encryption finished!");
        LOGGER.info("Produced ciphertext as block: " + Arrays.deepToString(stateArray));

        return stateArray;
    }

    private static int[][] substituteBytes(int[][] state) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                // Use masks of F0 and 0F to separate row/column values
                int row = (state[i][j] & LEFT_MASK) / 16;
                int column = (state[i][j] & RIGHT_MASK);
                newState[i][j] = S_BOX[row][column];
            }
        }
        return newState;
    }

    private static int[][] reverseSubstitution(int[][] state){
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++){
                //find the index of the element
                int value = state[i][j];
                //System.out.println(value);

                for(int k = 0; k < S_BOX.length; k++){
                    for(int l = 0; l < S_BOX.length; l++){
                        if(S_BOX[k][l] == value){

                            int first = k;
                            int second = (l);

                            String test =Integer.toHexString(first) + Integer.toHexString(second);
                            System.out.println(test);
                            newState[i][j] = Integer.parseInt(test,16) ;
                        }
                    }
                }

            }
        }
        return newState;
    }

    private static void subWord(int[] targetRow) {
        for (int i = 0; i < targetRow.length; i++) {
            int rowIndex = (targetRow[i] & LEFT_MASK) / 16;
            int columnIndex = (targetRow[i] & RIGHT_MASK);
            targetRow[i] = S_BOX[rowIndex][columnIndex];
        }
    }

    private static int[][] shiftRowsLeft(int[][] state) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            newState[i] = shiftRowLeft(state[i], i);
        }
        return newState;

    }

    private static int[] shiftRowLeft(int[] row, int shiftAmount) {
        int[] newRow = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            newRow[i] = row[(i + shiftAmount) % row.length];
        }
        return newRow;
    }

    private static int[][] shiftRowsRight(int[][] state) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = newState.length - 1; i >= 0; i--) {
            newState[i] = shiftRowRight(state[i], newState.length - i);
        }
        return newState;
    }

    private static int[] shiftRowRight(int[] row, int shiftAmount) {
        int[] newRow = new int[row.length];
        for (int i = newRow.length - 1; i >= 0; i--) {
            newRow[i] = row[(i + shiftAmount) % row.length];
        }
        return newRow;
    }

    private static int[][] mixColumns(int[][] state) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                // 'Rotating' the column to remove mental overhead
                newState[i][j] = multiplyRowByColumn(MCT[i], columnToArray(state, j));
            }
        }
        return newState;

    }

    private static int[] columnToArray(int[][] state, int j) {
        return new int[]{state[0][j], state[1][j], state[2][j], state[3][j]};
    }

    private static int multiplyRowByColumn(String[] row, int[] column) {
        int[] results = new int[column.length];
        for (int i = 0; i < row.length; i++) {
            results[i] = mixColumnValues(row[i], column[i]);
        }
        return results[0] ^ results[1] ^ results[2] ^ results[3];
    }

    private static int mixColumnValues(String operation, int stateValue) {
        if (operation.equals("01")) {
            return stateValue;
        } else {
            int returnValue;
            // Seemed easier to use substrings here, I'm open to suggestions
            // though
            String asBinary = Integer.toBinaryString(stateValue);
            String paddedBinary = "00000000".substring(asBinary.length()) + asBinary;
            String shifted = paddedBinary.substring(1) + "0";
            returnValue = Integer.parseInt(shifted, 2);
            if (paddedBinary.charAt(0) == '1') {
                returnValue = returnValue ^ 0x1b;
            }
            if (operation.equals("03")) {
                returnValue = returnValue ^ stateValue;
            }

            return returnValue;
        }
    }

    private static int[][] addRoundKey(int[][] state, int[][] key) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                newState[j][i] = state[j][i] ^ key[j][i];
            }
        }
        return newState;
    }

    private static int[][] keyExpansion(int[][] key, int numRounds) {
        int[][] newKey = new int[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            newKey[i] = Arrays.copyOf(key[i], key[i].length);
        }

        int rcon;
        if (numRounds < 9)
            rcon = 1 << (numRounds - 1);
        else {
            rcon = 1 << 8;
            for (int i = 8; i < numRounds; i++) {
                rcon = rcon << 1;
                if (rcon > 255)
                    rcon = rcon & 0xFF ^ 0x1b;
            }
        }

        int[] temp = columnToArray(key, 3);

        for (int i = 0; i < newKey.length; i++) {
            if (i == 0) {
                temp = shiftRowLeft(temp, 1); // rotWord
                subWord(temp);
                temp[0] = temp[0] ^ rcon;
            }

            int[] last = columnToArray(key, i);
            for (int j = 0; j < key[i].length; j++) {
                temp[j] = temp[j] ^ last[j];
                newKey[j][i] = temp[j];
            }
        }

        return newKey;

    }

    private static void printMatrixAsHex(String name, int[][] state) {
        System.out.println(name + ": ");
        for (int[] i : state) {
            for (int j : i) {
                System.out.print(Integer.toHexString(j) + " ");
            }
            System.out.print("\n");
        }
    }

    public static String decrypt(int[][] state) {
        // Lets do the inverse
        int[][] key = KEY;
        int[][][] allKeys = new int[10][4][4];
        //Getting and storing all keys to be accessed later
        for (int i = 1; i <= NUMBER_ROUNDS; i++) {
           key=keyExpansion(key, i);
           allKeys[i-1] = key;
        }
        int[][] lastRoundKey = addRoundKey(state, allKeys[9]);
        LOGGER.info("Before Last Round: " + Arrays.deepToString(lastRoundKey));

        int[][] newState = shiftRowsRight(lastRoundKey);
        LOGGER.info("Before final shift: " + Arrays.deepToString(newState));

        int[][] bSubState = reverseSubstitution(newState);
        LOGGER.info("Before sub : " + Arrays.deepToString(bSubState));

        for(int i = NUMBER_ROUNDS - 2; i>0; i--){
            int[][] round = addRoundKey(bSubState, allKeys[i]);
            LOGGER.info("Before  Round : " + (i+1)+ "---" + Arrays.deepToString(round));

        }

        return "";
    }

    public static void main(String[] args) {

        // Test row shifting
        int[] testRow = {0, 1, 2, 3};
        int[] resultRow = shiftRowLeft(testRow, 2);
        assert (Arrays.equals(resultRow, new int[]{2, 3, 0, 1}));

        int[] testRow2 = {0, 1, 2, 3};
        int[] resultRow2 = shiftRowLeft(testRow2, 3);
        assert (Arrays.equals(resultRow2, new int[]{3, 0, 1, 2}));

        int[][] testShiftRows = new int[][]{
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3}
        };
        int[][] expectedShiftRows = new int[][]{
                {0, 1, 2, 3},
                {1, 2, 3, 0},
                {2, 3, 0, 1},
                {3, 0, 1, 2}
        };
        int[][] resultShiftRows = shiftRowsLeft(testShiftRows);
        assert (Arrays.deepEquals(resultShiftRows, expectedShiftRows));


        // Test mixColumnValues
        int testOneMix = 0x5d;
        int testTwoMix = 0xd4;
        int testThreeMix = 0xbf;
        assert (mixColumnValues("01", testOneMix) == testOneMix);
        assert (mixColumnValues("02", testTwoMix) == 0xb3);
        assert (mixColumnValues("03", testThreeMix) == 0xda);
        assert (mixColumnValues("03", 0x41) == 0xc3);

        // Test full MCT
        int[][] testMixColumns = {
                {0xd4, 0xe0, 0xb8, 0x1e},
                {0xbf, 0xb4, 0x41, 0x27},
                {0x5d, 0x52, 0x11, 0x98},
                {0x30, 0xae, 0xf1, 0xe5},
        };

        int[][] resultMixColumns = mixColumns(testMixColumns);
        int[][] expectedMixColumns = {
                {0x04, 0xe0, 0x48, 0x28},
                {0x66, 0xcb, 0xf8, 0x06},
                {0x81, 0x19, 0xd3, 0x26},
                {0xe5, 0x9a, 0x7a, 0x4c}
        };
        assert (Arrays.deepEquals(resultMixColumns, expectedMixColumns));

        // Test add round key

        int[][] testKey = {
                {0xa0, 0x88, 0x23, 0x2a},
                {0xfa, 0x54, 0xa3, 0x6c},
                {0xfe, 0x2c, 0x39, 0x76},
                {0x17, 0xb1, 0x39, 0x05}
        };
        int[][] expectedKeyResult = {
                {0xa4, 0x68, 0x6b, 0x02},
                {0x9c, 0x9f, 0x5b, 0x6a},
                {0x7f, 0x35, 0xea, 0x50},
                {0xf2, 0x2b, 0x43, 0x49}
        };
        int[][] addRoundKeyResult = addRoundKey(expectedMixColumns, testKey);
        assert (Arrays.deepEquals(addRoundKeyResult, expectedKeyResult));

        int[][] testKeyExpansion = keyExpansion(KEY, 1);
        assert (Arrays.deepEquals(testKeyExpansion, testKey));

        int[][] testEncrypt = {
                {0x32, 0x88, 0x31, 0xe0},
                {0x43, 0x5a, 0x31, 0x37},
                {0xF6, 0x30, 0x98, 0x07},
                {0xA8, 0x8d, 0xa2, 0x34}
        };

        int[][] expectedEncryptOutput = {
                {0x39, 0x02, 0xdc, 0x19},
                {0x25, 0xdc, 0x11, 0x6a},
                {0x84, 0x09, 0x85, 0x0b},
                {0x1d, 0xfb, 0x97, 0x32}
        };

        int[][] resultEncryptOutput = encrypt(testEncrypt);
        assert (Arrays.deepEquals(resultEncryptOutput, expectedEncryptOutput));

        String test;
        if (args.length == 0) {
            test = "mark frequency  ";

        } else {
            test = args[0];
        }
        String ciphertext = encrypt(test);
        //Hardcoded new state to be removed
        int[][] newState = {{64, 38, 178, 31}, {56, 0, 56, 192}, {123, 179, 12, 195}, {179, 90, 70, 114}};
        String plaintext = decrypt(newState);
        //        assert (plaintext.equals(test));
    }
}
