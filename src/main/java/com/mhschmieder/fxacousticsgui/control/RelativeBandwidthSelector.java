/*
 * MIT License
 *
 * Copyright (c) 2020, 2025 Mark Schmieder
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
package com.mhschmieder.fxacousticsgui.control;

import com.mhschmieder.acousticstoolkit.RelativeBandwidth;
import com.mhschmieder.commonstoolkit.util.ClientProperties;
import com.mhschmieder.fxguitoolkit.control.TextSelector;

/**
 * The Relative Bandwidth Combo Box is a chooser for bandwidth ranges generally
 * considered useful for acoustic analysis modes, meaning divisors of 1/3 octave
 * as well as full octave. We do not yet support multi-octave bandwidth.
 * <p>
 * TODO: Redo as an enum-based XComboBox that provides a List Cell Factory.
 */
public final class RelativeBandwidthSelector extends TextSelector {

    // Default Relative Bandwidth, for best "out of box" experience.
    public static final String    RELATIVE_BANDWIDTH_DEFAULT
            = RelativeBandwidth.defaultValue().label();

    private static final String[] RELATIVE_BANDWIDTHS
            = new String[] {
                    RelativeBandwidth.ONE_OCTAVE.label(),
            RelativeBandwidth.THIRD_OCTAVE.label(),
            RelativeBandwidth.SIXTH_OCTAVE.label(),
            RelativeBandwidth.TWELTH_OCTAVE.label(),
            RelativeBandwidth.TWENTYFOURTH_OCTAVE.label() }; //,
            //RelativeBandwidth.FORTYEIGHTH_OCTAVE.label() };

    public RelativeBandwidthSelector( final ClientProperties pClientProperties,
                                      final boolean pToolbarContext ) {
        // Always call the superclass constructor first!
        super( pClientProperties,
               "Relative Bandwidth", //$NON-NLS-1$
               pToolbarContext,
               false,
               false,
               RELATIVE_BANDWIDTHS.length,
               RELATIVE_BANDWIDTH_DEFAULT,
               RELATIVE_BANDWIDTHS );
    }

    public RelativeBandwidth getRelativeBandwidth() {
        return RelativeBandwidth.defaultValue().valueOfLabel( getTextValue() );
    }

    public void setRelativeBandwidth( final RelativeBandwidth relativeBandwidth ) {
        setTextValue( relativeBandwidth.label() );
    }
}
