// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 1; page ??
// JUnit for Calc.java

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith (Parameterized.class)
public class DataDrivenCalcTest
{
   public int a, b, sum;

   public DataDrivenCalcTest (int a, int b, int sum)
   {
      this.a = a;
      this.b = b;
      this.sum = sum; 
   }

  @Parameters
  public static Collection<Object[]> calcValues()
  {
     return Arrays.asList (new Object [][] {{1, 1, 2}, {2, 3, 5}}); 
  }

  @Test
  public void additionTest()
  {
     assertTrue ("Addition Test", sum == Calc.add (a,b));
  }
}

