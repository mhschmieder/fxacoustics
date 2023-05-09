/**
 * MIT License
 *
 * Copyright (c) 2023 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the FxAcousticsGui Library
 *
 * You should have received a copy of the MIT License along with the
 * FxAcousticsGui Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxacousticsgui
 */
package com.mhschmieder.fxacousticsgui.control.cell;

import java.util.List;

import org.apache.commons.math3.util.FastMath;

import com.mhschmieder.fxguitoolkit.control.cell.DoubleEditorTableCell;
import com.mhschmieder.mathtoolkit.MathUtilities;

public class FrequencyEditorTableCell< RT, VT > extends DoubleEditorTableCell< RT, Double > {

    public FrequencyEditorTableCell( final boolean pAllowedToBeBlank ) {
        this( null, pAllowedToBeBlank );
    }

    public FrequencyEditorTableCell( final List< Integer > pUneditableRows,
                                  final boolean pAllowedToBeBlank ) {
        // Always call the superclass constructor first!
        super( pUneditableRows, pAllowedToBeBlank );
        
        // NOTE: For now, we don't support conversion to and from kHz.
        setMeasurementUnit( " Hz" );
    }

    @Override
    protected Double getEditorValue() {
        final Double editorValue = super.getEditorValue();
        return ( editorValue != null )
            ? Double.valueOf( adjustPrecision( editorValue.doubleValue() ) )
            : null;
    }

    @Override
    protected String getString() {
        final Double itemValue = getItem();
        if ( itemValue == null ) {
            return "";
        }
        
        final double doubleValue = itemValue.doubleValue();
        final String stringValue = ( doubleValue == Double.POSITIVE_INFINITY )
                ? "-"
                : _numberFormat.format( adjustPrecision( doubleValue ) )
                        + _measurementUnit;
        
        return stringValue;
    }
    
    @Override
    protected String getTextValue() {
        final Double itemValue = getItem();
        if ( itemValue == null ) {
            return "";
        }

        final double doubleValue = itemValue.doubleValue();
        final String textValue = ( doubleValue == Double.POSITIVE_INFINITY )
                ? "-"
                : Double.toString( adjustPrecision( doubleValue ) );
        
        return textValue;
    }

    public double adjustPrecision( final double doubleValue ) {
        final double precisionAdjustedValue = ( doubleValue >= 100.0d )
            ? FastMath.round( doubleValue )
            : MathUtilities.roundDecimal( doubleValue, 1 );
        return precisionAdjustedValue;
    }
}
