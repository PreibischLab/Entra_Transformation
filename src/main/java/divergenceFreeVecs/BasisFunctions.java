package divergenceFreeVecs;

import Jama.Matrix;

public interface BasisFunctions {

	
	
	public void BasisFunction (final Matrix Inputvectors, final Matrix Centralvectors, double constspace, double Basisspacing) throws NotEnoughVectorsException;
		
		
	
	
}
