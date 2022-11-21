package inclass_11.src;

public class ColorPoint extends Point { // First attempt: Standard recipe
   private String color;

   public ColorPoint(int x, int y, String color) {
      super(x, y);
      this.color = color;
   }

   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof ColorPoint))
         return false;

      ColorPoint cp = (ColorPoint) obj;
      return super.equals(obj) && cp.color.equals(color);
   }
}