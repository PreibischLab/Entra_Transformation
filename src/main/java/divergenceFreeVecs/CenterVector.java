package divergenceFreeVecs;

import Jama.Matrix;

public abstract class CenterVector implements BasisFunctions {
	
	
       public void Function(final Matrix Inputvectors,  final int Numberbasis, final double Basisspacing, final double  constspace) throws NotEnoughVectorsException {
		
		int colsize = Inputvectors.getColumnDimension();
		int rowsize = Inputvectors.getRowDimension();
		double[][] Inputarray = Inputvectors.getArray();
		double[] Inputarraycenter = new double[rowsize];
		double[][] FullbasisVecCenter = new double[rowsize][Numberbasis];
		
		for (int rowindex = 0; rowindex < Inputvectors.getRowDimension(); ++rowindex ){
		for (int colindex = 0; colindex < Inputvectors.getColumnDimension(); ++colindex ){
			
			Inputarraycenter[rowindex]+= Inputarray[rowindex][colindex] / colsize;
		}
		}
		
		
		
		
		for (int basisindex = 0 ; basisindex < Numberbasis / 2; ++basisindex){
			
			for (int rowindex = 0; rowindex < Inputarraycenter.length; ++rowindex){
				
				FullbasisVecCenter[rowindex][basisindex] = Inputarraycenter[rowindex] + ( basisindex ) * Basisspacing;
				
				
			}
			
		}
		
        for (int basisindex = Numberbasis / 2 ; basisindex < Numberbasis; ++basisindex){
			
			for (int rowindex = 0; rowindex < Inputarraycenter.length; ++rowindex){
				
				FullbasisVecCenter[rowindex][basisindex] = Inputarraycenter[rowindex] - ( basisindex - Numberbasis / 2 + 1 ) * Basisspacing;
				
				
			}
			
		}
		
		
		
		// Create Matrix from vector
		Matrix Inputcenter = new Matrix(FullbasisVecCenter);
		
		BasisFunction(Inputvectors, Inputcenter, constspace, Basisspacing); 
		
	}

	

}
