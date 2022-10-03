package assignment_5;

// TODO 1: Implement repOk() for the above rep-invariant

// TODO 2: Explain why the degree() method is correct
// TODO 2a: Is the rep-invariant maintained?
// TODO 2b: Is the specification satisfied? In other words, is "deg" actually the degree of the polynomial?

// TODO 3: Modify the rep-invariant by removing "if deg > 0 then trms[deg] != 0 (no trailing zeros)". Implement the resulting repOk() for it.

// TODO 4: Fix the degree() method to support the new rep-invariant

// TODO 5: Explain why your new implementation of the degree() method is correct

// TODO 6: What if we ommit "trms != null" from the rep-invariant. How would the code look like in Poly? (describe in one sentence)

public class Poly {
    // Polys are immutable polynomials c0 + c1x + c2x^2 + …
    // AF: ci = trms[i] for appropriate values of i
    // rep-inv: deg = trms.length-1
    // trms.length >= 1
    // trms != null
    // if deg > 0 then trms[deg] != 0 (no trailing zeros)
    int[] trms;
    int deg; // the representation (deg is redundant)

    // Postcondition: Return degree of this (i.e., the largest exponent with
    // coefficient != 0)
    public int degree() {
        return deg;
    }

    // Other methods ...
}
