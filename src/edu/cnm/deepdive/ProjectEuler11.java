package edu.cnm.deepdive;

import java.io.IOException;

public class ProjectEuler11 {

  public static void main(String[] args) throws IOException {
    DataLoader loader = new DataLoader("largest-product-data.txt");
    int [][] data = loader.load();
    System.out.println(maxProduct(data, 4));
  }

  public static int maxProduct(int[][] data, int productLength) {
    int maxProduct = Integer.MIN_VALUE;
    for (int row = 0; row < data.length; row++) {
      for (int col = 0; col < data[row].length; col++) {
        maxProduct = Math.max(maxProduct, maxProduct(data, productLength, row, col));
      }
      }

    return maxProduct;
  }
  private static int maxProduct(int[][] data, int productLength, int row, int col) {
    int best = Integer.MIN_VALUE;
    for (Direction direction: Direction.values()){
      try {
        int product = 1;
        for (int step = 0; step < productLength; step++){
          product *= data[row + step * direction.rowOffSet] [col + step * direction.colOffSet];
        }
        best = Math.max(best, product);
      } catch (ArrayIndexOutOfBoundsException e) {
        //DO Nothing!
      }
    }
    return best;
  }
  private enum Direction{
    NORTH(-1,0),
    NORTHEAST(-1,1),
    EAST(0,1),
    SOUTHEST(1,1);

    public final int rowOffSet;
    public final int colOffSet;

    Direction(int rowOffSet, int colOffSet) {
      this.rowOffSet = rowOffSet;
      this.colOffSet = colOffSet;
    }
  }
}
