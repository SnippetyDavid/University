package encryption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * Utility class which provides static methods for AES-128 encryption and decryption.
 */
public class AES {

    private final static Logger LOGGER = Logger.getLogger(AES.class.getName());

    /**
     * Hard coded final values for encryption and decryption
     */
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

    private static final int[][] INVERSE_S_BOX = {
            {0x52, 0x09, 0x6a, 0xd5, 0x30, 0x36, 0xa5, 0x38, 0xbf, 0x40, 0xa3, 0x9e, 0x81, 0xf3, 0xd7, 0xfb},
            {0x7c, 0xe3, 0x39, 0x82, 0x9b, 0x2f, 0xff, 0x87, 0x34, 0x8e, 0x43, 0x44, 0xc4, 0xde, 0xe9, 0xcb},
            {0x54, 0x7b, 0x94, 0x32, 0xa6, 0xc2, 0x23, 0x3d, 0xee, 0x4c, 0x95, 0x0b, 0x42, 0xfa, 0xc3, 0x4e},
            {0x08, 0x2e, 0xa1, 0x66, 0x28, 0xd9, 0x24, 0xb2, 0x76, 0x5b, 0xa2, 0x49, 0x6d, 0x8b, 0xd1, 0x25},
            {0x72, 0xf8, 0xf6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xd4, 0xa4, 0x5c, 0xcc, 0x5d, 0x65, 0xb6, 0x92},
            {0x6c, 0x70, 0x48, 0x50, 0xfd, 0xed, 0xb9, 0xda, 0x5e, 0x15, 0x46, 0x57, 0xa7, 0x8d, 0x9d, 0x84},
            {0x90, 0xd8, 0xab, 0x00, 0x8c, 0xbc, 0xd3, 0x0a, 0xf7, 0xe4, 0x58, 0x05, 0xb8, 0xb3, 0x45, 0x06},
            {0xd0, 0x2c, 0x1e, 0x8f, 0xca, 0x3f, 0x0f, 0x02, 0xc1, 0xaf, 0xbd, 0x03, 0x01, 0x13, 0x8a, 0x6b},
            {0x3a, 0x91, 0x11, 0x41, 0x4f, 0x67, 0xdc, 0xea, 0x97, 0xf2, 0xcf, 0xce, 0xf0, 0xb4, 0xe6, 0x73},
            {0x96, 0xac, 0x74, 0x22, 0xe7, 0xad, 0x35, 0x85, 0xe2, 0xf9, 0x37, 0xe8, 0x1c, 0x75, 0xdf, 0x6e},
            {0x47, 0xf1, 0x1a, 0x71, 0x1d, 0x29, 0xc5, 0x89, 0x6f, 0xb7, 0x62, 0x0e, 0xaa, 0x18, 0xbe, 0x1b},
            {0xfc, 0x56, 0x3e, 0x4b, 0xc6, 0xd2, 0x79, 0x20, 0x9a, 0xdb, 0xc0, 0xfe, 0x78, 0xcd, 0x5a, 0xf4},
            {0x1f, 0xdd, 0xa8, 0x33, 0x88, 0x07, 0xc7, 0x31, 0xb1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xec, 0x5f},
            {0x60, 0x51, 0x7f, 0xa9, 0x19, 0xb5, 0x4a, 0x0d, 0x2d, 0xe5, 0x7a, 0x9f, 0x93, 0xc9, 0x9c, 0xef},
            {0xa0, 0xe0, 0x3b, 0x4d, 0xae, 0x2a, 0xf5, 0xb0, 0xc8, 0xeb, 0xbb, 0x3c, 0x83, 0x53, 0x99, 0x61},
            {0x17, 0x2b, 0x04, 0x7e, 0xba, 0x77, 0xd6, 0x26, 0xe1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0c, 0x7d}
    };

    private static final int LEFT_MASK = 0xF0;
    private static final int RIGHT_MASK = 0x0F;

    // Arrays of operations for MCT and inverse
    private static final int[][] MCT = {
            {0x02, 0x03, 0x01, 0x01},
            {0x01, 0x02, 0x03, 0x01},
            {0x01, 0x01, 0x02, 0x03},
            {0x03, 0x01, 0x01, 0x02}
    };

    private static final int[][] INVERSE_MCT = {
            {0x0e, 0x0b, 0x0d, 0x09},
            {0x09, 0x0e, 0x0b, 0x0d},
            {0x0d, 0x09, 0x0e, 0x0b},
            {0x0b, 0x0d, 0x09, 0x0e}
    };

    /**
     * Overrides the default constructor to prevent instantiation of AES, as it provides all useful functions
     * statically
     */
    private AES() {
    }

    /**
     * Encrypts a string using AES-128, and returns the encrypted string as a new Base64 encoded string. Base64
     * encoding is used to prevent errors when transforming back into ASCII.
     *
     * @param plaintext text to be encrypted
     * @return Base64 encoded ciphertext string
     */
    public static String encrypt(String plaintext) {
        byte[] text = plaintext.getBytes();
        int padding = text.length % 16;
        if (padding != 0)
            padding = 16 - padding;

        byte[] paddedBytes = Arrays.copyOf(text, text.length + padding);
        ArrayList<Byte> cipherBytes = new ArrayList<Byte>();
        for (int i = 0; i < paddedBytes.length; i += 16) {
            byte[] targetBytes = Arrays.copyOfRange(paddedBytes, i, i + 16);
            int[][] stateArray = byteToBlock(targetBytes);
            stateArray = encrypt(stateArray);
            for (byte b : blockToBytes(stateArray))
                cipherBytes.add(b);
        }

        byte[] byteArray = new byte[cipherBytes.size()];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = cipherBytes.get(i);
        }

        return Base64.getEncoder().encodeToString(byteArray);
    }

    /**
     * Takes a two dimensional array of ints, arranged as described in the AES specification, and performs 10 rounds
     * of AES encryption on them.
     *
     * @param stateArray input block
     * @return output block of integers
     */
    private static int[][] encrypt(int[][] stateArray) {
        LOGGER.info("Starting AES encryption");

        int[][] key = KEY;
        stateArray = addRoundKey(stateArray, key);

        for (int i = 1; i <= NUMBER_ROUNDS; i++) {
            LOGGER.info("Starting AES encryption round " + i);
            key = keyExpansion(key, i);
            stateArray = substituteBytes(stateArray);
            stateArray = shiftRowsLeft(stateArray);
            if (i < NUMBER_ROUNDS) {
                stateArray = forwardMixColumns(stateArray);
            }
            stateArray = addRoundKey(stateArray, key);
        }
        LOGGER.info("Encryption finished!");

        return stateArray;
    }

    /**
     * Decrypts a Base64 encoded string of ciphertext produced using AES-128 encryption.
     *
     * @param ciphertext Base64 encoded ciphertext
     * @return decrypted string as plaintext
     */
    public static String decrypt(String ciphertext) {
        byte[] text = Base64.getDecoder().decode(ciphertext.getBytes());
        int padding = text.length % 16;
        if (padding != 0)
            padding = 16 - padding;

        byte[] paddedBytes = Arrays.copyOf(text, text.length + padding);
        String plaintext = "";
        for (int i = 0; i < paddedBytes.length; i += 16) {
            byte[] targetBytes = Arrays.copyOfRange(paddedBytes, i, i + 16);
            int[][] stateArray = byteToBlock(targetBytes);
            stateArray = decrypt(stateArray);
            plaintext += new String(blockToBytes(stateArray));
        }

        for (int i = 0; i < plaintext.length(); i++) {
            if (plaintext.charAt(i) == 0) {
                plaintext = plaintext.substring(0, i);
                break;
            }
        }
        return plaintext;
    }

    /**
     * Takes a two dimensional array of ints, arranged as described in the AES specification, and performs 10 rounds
     * of AES decryption on them.
     *
     * @param state input matrix
     * @return output matrix
     */
    private static int[][] decrypt(int[][] state) {
        LOGGER.info("Starting AES decryption");
        int[][] key = KEY;
        int[][][] allKeys = new int[10][4][4];
        int[][] newState;
        //Getting and storing all keys to be accessed later
        for (int i = 1; i <= NUMBER_ROUNDS; i++) {
            key = keyExpansion(key, i);
            allKeys[i - 1] = key;
        }
        newState = addRoundKey(state, allKeys[9]);


        for (int i = NUMBER_ROUNDS - 1; i > 0; i--) {
            newState = shiftRowsRight(newState);
            newState = reverseSubBytes(newState);
            newState = addRoundKey(newState, allKeys[i - 1]);
            newState = inverseMixColumns(newState);
        }
        newState = shiftRowsRight(newState);
        newState = reverseSubBytes(newState);
        newState = addRoundKey(newState, KEY);
        LOGGER.info("AES decryption finished");


        return newState;
    }

    /**
     * S-Box lookup wrapper method, for use in encryption
     * @param state input matrix
     * @return output matrix
     */
    private static int[][] substituteBytes(int[][] state) {
        return sBoxLookup(state, S_BOX);
    }

    /**
     * S-Box lookup wrapper method, for use in decryption
     * @param state input matrix
     * @return output matrix
     */
    private static int[][] reverseSubBytes(int[][] state) {
        return sBoxLookup(state, INVERSE_S_BOX);
    }

    /**
     * For every entry in a two dimensional int input array, performs and S Box substitution using either the S Box or
     * Inverse S Box described in the AES specification.
     * @param state input matrix
     * @param transformation two dimensional S Box to use for substitution
     * @return output matrix, with all values from the input matrix substituted
     */
    private static int[][] sBoxLookup(int[][] state, int[][] transformation) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                // Use masks of F0 and 0F to separate row/column values
                int row = (state[i][j] & LEFT_MASK) / 16;
                int column = (state[i][j] & RIGHT_MASK);
                newState[i][j] = transformation[row][column];
            }
        }
        return newState;
    }

    /**
     * Performs an S Box lookup for a word at a time.
     * @param targetRow array of input integers to substitute.
     */
    private static void subWord(int[] targetRow) {
        for (int i = 0; i < targetRow.length; i++) {
            int rowIndex = (targetRow[i] & LEFT_MASK) / 16;
            int columnIndex = (targetRow[i] & RIGHT_MASK);
            targetRow[i] = S_BOX[rowIndex][columnIndex];
        }
    }

    /**
     * Shifts every row in an input matrix to the left, by an amount which matches its index. For example, the 0th row
     * of the matrix would be shifted by 0 places, while the 2nd row would be shifted by 2 places.
     * @param state input matrix
     * @return output shifted matrix
     */
    private static int[][] shiftRowsLeft(int[][] state) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            newState[i] = shiftRowLeft(state[i], i);
        }
        return newState;

    }

    /**
     * Shift an individual array to the left by an input number of places.
     * @param row row to be shifted
     * @param shiftAmount number of places to shift the values in the array by
     * @return shifted row
     */
    private static int[] shiftRowLeft(int[] row, int shiftAmount) {
        int[] newRow = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            newRow[i] = row[(i + shiftAmount) % row.length];
        }
        return newRow;
    }

    /**
     * Shifts every row in an input matrix to the right, by an amount which matches its index. For example, the 0th row
     * of the matrix would be shifted by 0 places, while the 2nd row would be shifted by 2 places.
     * @param state input matrix
     * @return output shifted matrix
     */
    private static int[][] shiftRowsRight(int[][] state) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = newState.length - 1; i >= 0; i--) {
            newState[i] = shiftRowRight(state[i], newState.length - i);
        }
        return newState;
    }

    /**
     * Shift an individual array to the right by an input number of places.
     * @param row row to be shifted
     * @param shiftAmount number of places to shift the values in the array by
     * @return shifted row
     */
    private static int[] shiftRowRight(int[] row, int shiftAmount) {
        int[] newRow = new int[row.length];
        for (int i = newRow.length - 1; i >= 0; i--) {
            newRow[i] = row[(i + shiftAmount) % row.length];
        }
        return newRow;
    }

    /**
     * Performs a mix column transformation for use in encryption.
     * @param state input matrix
     * @return output matrix
     */
    private static int[][] forwardMixColumns(int[][] state) {
        return mixColumns(state, MCT);
    }

    /**
     * Performs an inverse mix column transformation for use in decryption
     * @param state input matrix
     * @return output matrix
     */
    private static int[][] inverseMixColumns(int[][] state) {
        return mixColumns(state, INVERSE_MCT);
    }

    /**
     * Performs a mix column transformation using an input two dimensional matrix of operations. Calculates new values
     * for an input array using a matrix multiplication.
     * @param state input matrix
     * @param transformation two dimensional array of values to multiply by
     * @return ouput matrix
     */
    private static int[][] mixColumns(int[][] state, int[][] transformation) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                // 'Rotating' the column to remove mental overhead
                newState[i][j] = multiplyRowByColumn(transformation[i], columnToArray(state, j));
            }
        }
        return newState;
    }

    /**
     * Returns a target column from a particular matrix as a one-dimensional array.
     * @param state input matrix
     * @param j index of column to be 'rotated'
     * @return column as a one dimensional array
     */
    private static int[] columnToArray(int[][] state, int j) {
        // Param j is the index of the column
        return new int[]{state[0][j], state[1][j], state[2][j], state[3][j]};
    }

    /**
     * Multiplies a row by a column for use in matrix multiplications, then XORs the results to provide a single return
     *  value during MCT.
     * @param row input row of ints
     * @param column input column of ints
     * @return result of multiplying the row by the column, then XORing output values.
     */
    private static int multiplyRowByColumn(int[] row, int[] column) {
        int[] results = new int[column.length];
        for (int i = 0; i < row.length; i++) {
            results[i] = finiteFieldMultiplication(row[i], column[i]);
        }
        return results[0] ^ results[1] ^ results[2] ^ results[3];
    }

    /**
     * Performs a multiplication of y by x, for an 8 bit number. Deals with overflow as appropriate.
     * @param x - the number of times by which to multiply y
     * @param y - the number to be multiplied
     * @return result xy
     */
    private static int finiteFieldMultiplication(int x, int y) {
        int result = y;

        // First calculate the order in which to perform the operations upon y by reducing x to 1 by only
        // halving it or subtracting 1. This gives the sequence of operations which need to be performed upon
        // y to turn it from y into xy.
        ArrayList<Integer> operations = new ArrayList<>();
        int loopCounter = x;
        while (loopCounter > 1) {
            if (loopCounter % 2 != 0) {
                loopCounter--;
                // Add at 0 to provide the sequence of operations in the forward direction
                operations.add(0, 1);
            } else {
                loopCounter = loopCounter / 2;
                operations.add(0, 2);
            }
        }

        // Apply the operations in order, where 1 indicates that y should be added to the current number, while
        // 2 indicates that the current number should be doubled.
        for (int operation : operations) {
            if (operation == 1) {
                result = result ^ y;
            } else if (operation == 2) {
                result = result << 1;
                if (result > 255)
                    result = result & 0xff ^ 0x1b;
            }
        }
        return result;
    }

    /**
     * Adds the round key during encryption by XORing values from the input state matrix with corresponding values from
     * an input key matrix, and returns the result.
     * @param state input matrix
     * @param key input key matrix
     * @return result of XORing each value of state with corresponding values from key
     */
    private static int[][] addRoundKey(int[][] state, int[][] key) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                newState[j][i] = state[j][i] ^ key[j][i];
            }
        }
        return newState;
    }

    /**
     * Performs a key expansion on an input key, by calculating a round constant and using this to produce a new key.
     * @param key input key matrix
     * @param numRounds current round number, used to produce round constant.
     * @return output key matrix
     */
    private static int[][] keyExpansion(int[][] key, int numRounds) {
        int[][] newKey = new int[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            newKey[i] = Arrays.copyOf(key[i], key[i].length);
        }

        int rcon;
        if (numRounds < 9)
            // 2^7 is the largest value that can be represented by 8 bits without having some funk
            rcon = 1 << (numRounds - 1);
        else {
            rcon = 1 << 8;
            // Continue to double until target rcon is reached, wrapping any time the maximum value is exceeded.
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

    /**
     * Utility method for debugging. Provides an easy way to print a matrix to sysout in
     * a human readable form, with a specified message.
     *
     * @param name  - string to print before matrix
     * @param state - matrix to be printed
     */
    private static void printMatrixAsHex(String name, int[][] state) {
        System.out.println(name + ": ");
        for (int[] i : state) {
            for (int j : i) {
                System.out.print(Integer.toHexString(j) + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Takes an input array of precisely 16 bytes, and places them into a matrix as described in the AES specification
     * for use in transformations.
     * @param bytes input array of bytes
     * @return output two dimensional array of 8 bit integers
     */
    private static int[][] byteToBlock(byte[] bytes) {
        int[][] stateArray = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                stateArray[j][i] = bytes[(4 * i) + j];
            }
        }
        return stateArray;
    }

    /**
     * Takes a two dimensional 4x4 input array, and returns a single array.
     * @param stateArray input matrix
     * @return array of bytes
     */
    private static byte[] blockToBytes(int[][] stateArray) {

        byte[] resultBytes = new byte[16];
        for (int i = 0; i < stateArray.length; i++) {
            for (int j = 0; j < stateArray[i].length; j++) {
                resultBytes[(4 * i) + j] = (byte) stateArray[j][i];
            }
        }

        return resultBytes;
    }

    /**
     * Main method. Used to run tests
     */
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
        int[][] resultInvShiftRows = shiftRowsRight(resultShiftRows);
        assert (Arrays.deepEquals(resultInvShiftRows, testShiftRows));


        // Test mixColumnValues
        assert (finiteFieldMultiplication(0x01, 0x5d) == 0x5d);
        assert (finiteFieldMultiplication(0x02, 0xd4) == 0xb3);
        assert (finiteFieldMultiplication(0x03, 0xbf) == 0xda);
        assert (finiteFieldMultiplication(0x03, 0x41) == 0xc3);
        assert (multiplyRowByColumn(INVERSE_MCT[0], new int[]{0xe0, 0xcb, 0x19, 0x9a}) == 0xe0);
        assert (multiplyRowByColumn(INVERSE_MCT[0], new int[]{0x04, 0x66, 0x81, 0xe5}) == 0xd4);


        // Test full MCT
        int[][] testMixColumns = {
                {0xd4, 0xe0, 0xb8, 0x1e},
                {0xbf, 0xb4, 0x41, 0x27},
                {0x5d, 0x52, 0x11, 0x98},
                {0x30, 0xae, 0xf1, 0xe5},
        };

        int[][] resultMixColumns = forwardMixColumns(testMixColumns);
        int[][] expectedMixColumns = {
                {0x04, 0xe0, 0x48, 0x28},
                {0x66, 0xcb, 0xf8, 0x06},
                {0x81, 0x19, 0xd3, 0x26},
                {0xe5, 0x9a, 0x7a, 0x4c}
        };
        assert (Arrays.deepEquals(resultMixColumns, expectedMixColumns));

        int[][] reverseMixColumns = inverseMixColumns(expectedMixColumns);
        assert (Arrays.deepEquals(reverseMixColumns, testMixColumns));


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

        int[][] resultDecryptOutput = decrypt(resultEncryptOutput);
        assert (Arrays.deepEquals(resultDecryptOutput, testEncrypt));


        String test = "mark frequency  ";
        String ciphertext = encrypt(test);
        String plaintext = decrypt(ciphertext);
        assert (plaintext.equals(test));

        String test2 = "superBigLongTestStringerinoooO";
        String ciphertext2 = encrypt(test2);
        String plaintext2 = decrypt(ciphertext2);
        assert (plaintext2.equals(test2));

        String test3 = "cats";
        String ciphertext3 = encrypt(test3);
        String plaintext3 = decrypt(ciphertext3);
        assert (plaintext3.equals(test3));
    }
}
