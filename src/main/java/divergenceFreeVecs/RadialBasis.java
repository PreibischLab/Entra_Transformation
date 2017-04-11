package divergenceFreeVecs;

import java.util.ArrayList;

import Jama.Matrix;
import mpicbg.models.Point;

public class RadialBasis extends CenterVector implements BasisFunctions {

	@Override
	public void BasisFunction(Matrix Inputvectors, Matrix Centralvectors, double constspace, double Basisspacing) throws NotEnoughVectorsException {

		// Write the radial basis function here

		if (Inputvectors.getColumnDimension() < 2 )
			throw new NotEnoughVectorsException(" Minimum of two vectors needed for transformation ");
		
		final double sigma = constspace * Basisspacing;
		double[][] Allcenter = new double[Centralvectors.getRowDimension()][Centralvectors.getColumnDimension()];
		double[][] Allinput = new double[Inputvectors.getRowDimension()][Inputvectors.getColumnDimension()];

		for (int rowindex = 0; rowindex < Centralvectors.getRowDimension(); ++rowindex) {

			for (int colindex = 0; colindex < Centralvectors.getColumnDimension(); ++colindex) {

				Allcenter[rowindex][colindex] = Centralvectors.get(rowindex, colindex);
				System.out.println(Allcenter[rowindex][colindex]);
			}
		}
		
		for (int rowindex = 0; rowindex < Inputvectors.getRowDimension(); ++rowindex) {

			for (int colindex = 0; colindex < Inputvectors.getColumnDimension(); ++colindex) {

				Allinput[rowindex][colindex] = Inputvectors.get(rowindex, colindex);

				System.out.println(Allinput[rowindex][colindex]);
			}
		}
		
		
		

		/*
		 * 
		 * 
		 * Matrix Diff = Inputvectors.get(rowindex,
		 * 0).minus(Centralvectors.get(rowindex, colindex)); double EuclidNorm =
		 * Diff.norm2(); double Expnorm = Math.exp(- EuclidNorm / (2 * sigma
		 * *sigma));
		 * 
		 * System.out.println(Expnorm);
		 */
	}

	public static void main(String[] args) throws NotEnoughVectorsException {

		final ArrayList<Double> points = new ArrayList<Double>();

		points.add(1.0);
		points.add(2.0);
		points.add(3.0);
		points.add(4.0);
		points.add(5.0);
		points.add(6.0);
		points.add(7.0);
		points.add(8.0);
		points.add(9.0);
		int Npoints = points.size();
		double[] x = new double[Npoints];
		int count = 0;
		for (final double p : points) {

			x[count] = p;

			count++;

		}

		Matrix input = new Matrix(x, Npoints);
		int Numberbasis = 4;
		double Basisspacing = 0.5;
		double constspace = 0.7;

		RadialBasis newbasisset = new RadialBasis();
		newbasisset.Function(input, Numberbasis, Basisspacing, constspace);

	}

}
