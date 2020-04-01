package com.eonsahead.operator;

public class Operator {

    private double[][] elements = new double[4][4];

    public Operator() {
        this.identity();
    } // Operator()

    public double get(int row, int column) {
        return this.elements[row][column];
    } // get( int, int )

    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    } // set( int, int, double )

    public final void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    this.set(i, j, 1.0);
                } // if
                else {
                    this.set(i, j, 0.0);
                } // else
            } // for
        } // for
    } // identity()

    public void rotationZ(double angle) {
        this.identity();
        this.elements[0][0] = Math.cos(angle);
        this.elements[0][1] = -Math.sin(angle);
        this.elements[1][0] = Math.sin(angle);
        this.elements[1][1] = Math.cos(angle);
    } // rotation( double )

    public Operator multiply(Operator otherOperator) {
        Operator product = new Operator();
        for( int row = 0; row < 4; row++ ) {
            for( int column = 0; column < 4; column++ ) {
                double sum = 0.0;
                for( int k = 0; k < 4; k++ ) {
                    sum += this.get( row, k) * otherOperator.get( k, column);
                } // for
                product.set( row, column, sum);
            } // for
        } // for

        return product;
    } // multiply( Operator )

    private String rowToString( int row ) {
        StringBuilder result = new StringBuilder();
        
        result.append( "(" );
        for( int i = 0; i < 3; i++ ) {
            result.append( this.get(row, i ));
            result.append( ", ");
        } // for
        result.append( this.get(row, 3 ));
        result.append( ")" );
        
        return result.toString();
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        result.append( "[" );
        for( int i = 0; i < 3; i++ ) {
            result.append( rowToString(i) );
            result.append( "," );
        } // for
        result.append( rowToString(3));
        result.append( "]" );
        return result.toString();
    } // toString()

    public static void main(String[] args) {
        Operator identity = new Operator();
        System.out.println("Identity = " + identity);

        Operator product = identity.multiply(identity);
        System.out.println("Product = " + product);

        Operator ccw = new Operator();
        ccw.rotationZ(Math.PI / 4);

        Operator cw = new Operator();
        cw.rotationZ(-Math.PI / 4);

        Operator totalRotation = ccw.multiply(cw);

        System.out.println("ccw = " + ccw);
        System.out.println("cw = " + cw);
        System.out.println("total rotation = " + totalRotation);
    } // main( String [] )

} // Operator
