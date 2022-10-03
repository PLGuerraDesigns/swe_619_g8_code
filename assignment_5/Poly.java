package assignment_5;

public class Poly {
    // Polys are immutable polynomials c0 + c1x + c2x^2 + …
    // AF: ci = trms[i] for appropriate values of i
    // rep-inv: deg = trms.length-1
    //          trms.length >= 1
    //          trms != null
    //          if deg > 0 then trms[deg] != 0 (no trailing zeros)
    int[] trms;
    int deg; // the representation (deg is redundant)

    // Postcondition: Return degree of this (i.e., the largest exponent with
    // coefficient != 0)
    public int degree() {
        return deg;
    }
    
    // Other methods ...

    // TODO 1: Implement repOk() for the above rep-invariant
    public boolean repOk() {
        if(deg != trms.length - 1 || trms.length < 1 || trms == null || (deg > 0 && trms[deg] == 0)) 
            return false;
        return true;
    }

    /* TODO 2: Explain why the degree() method is correct
        The degree() method is correct because it meets the specification (precondition) and the rep-invariant is maintained 
        because in math, the degree of a polynomial is always the number of terms minus one */


    /* TODO 3: Modify the rep-invariant by removing "if deg > 0 then trms[deg] != 0 (no trailing zeros)". 
       Implement the resulting repOk() for it. */
    public boolean repOkModified() {
        if(deg != trms.length - 1 || trms.length < 1 || trms == null) 
            return false;
        return true;
    }

    // TODO 4: Fix the degree() method to support the new rep-invariant
    public int degreeModified() {
        if(deg > 0 && trms[deg] == 0)
            throw new Exception("rep invariant not maintained");
        return deg;
    }

    /* TODO 5: Explain why your new implementation of the degree() method is correct
        Our new implementation of the degree() method is correct because if the rep-invariant is not maintained, it throws an exception.
        Otherwise, it meets the specification for the degree() method */

    /* TODO 6: What if we ommit "trms != null" from the rep-invariant. How would the code look like in Poly? (describe in one sentence)
        If "trms != null" is ommitted from the rep-invaraint, the degree() and repOk() methods would have to be modified to throw 
        exceptions if "trms == null" */
}
