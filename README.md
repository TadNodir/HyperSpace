Romana in hyper space

The bounty hunter Romana pursues a fugitive criminal across the universe.
Fortunately, hyperspace jumps made it a lot easier to visit multiple planets
quickly. Each planet pn ∈ P has a number of portals into the
Hyperspace network R ⊆ P x P. Each portal is on a different planet with a portal
connected. For obvious security reasons, these hyperspace routes (x, y) ∈ R are only
passable in one direction, one portal being the entry point G and the other portal being the the exit point H from hyperspace.
In addition, the network of hyperspace routes must
be cycle-free to avoid accidents during hyperspace jumps. That means it is not allowed in
Hyperspace network to have p1,...,pn for i = 1,..,n with p1 = pn.

While looking at her star map, Romana wonders how many droids she can use for a search
on every planet. The droids have to be from different planets
Start time out, otherwise the criminal could become suspicious and flee. Everyone can
Launch droid from a planet of your choice and follow the hyperspace routes of planet
move to planet, but it is still bound by the boundaries of the hyperspace web.

A1.Input

Your program accepts a path to a text file as the only command line argument.
Use the readFile method of the Terminal class to read the contents of this file
read. You cannot assume that the given input is after the given
specifications. Incorrect entries lead to the termination of the program after
a suitable error message was issued.

The text file starts with an integer N (1<N<=1000) which specifies is the number of planets. 
The planets P are numbered from 0 to N-1. The following N lines represent
the hyperspace routes. The i-th of these lines first contains the number of connections
K (0<=K<=N-1) from planet i, followed by K integers indicating the target planets.

A2.Output

Output the minimum number of droids needed to visit each planet.
