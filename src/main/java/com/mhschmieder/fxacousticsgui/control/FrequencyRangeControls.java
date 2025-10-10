/**
 * MIT License
 *
 * Copyright (c) 2020, 2023 Mark Schmieder
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

import com.mhschmieder.acousticstoolkit.FrequencyRange;
import com.mhschmieder.acousticstoolkit.FrequencySignalUtilities;
import com.mhschmieder.acousticstoolkit.RelativeBandwidth;
import com.mhschmieder.commonstoolkit.util.ClientProperties;

import java.text.NumberFormat;

public final class FrequencyRangeControls {

    // Declare controls for Frequency Range related actions.
    public RelativeBandwidthSelector _relativeBandwidthSelector;
    public OctaveRangeSelector       _octaveRangeSelector;
    public CenterFrequencySelector   _centerFrequencySelector;

    // Number format cache used for locale-specific number formatting.
    protected NumberFormat           _numberFormat;

    // Default constructor
    public FrequencyRangeControls( final NumberFormat numberFormat,
                                   final ClientProperties pClientProperties,
                                   final boolean applyToolkitCss,
                                   final boolean useExtendedRange,
                                   final int startIndexForOneOctave,
                                   final int startIndexForThirdOctave ) {
        _numberFormat = numberFormat;

        // Make the individual controls.
        _relativeBandwidthSelector =
                                   new RelativeBandwidthSelector( pClientProperties, applyToolkitCss );
        _octaveRangeSelector = new OctaveRangeSelector( pClientProperties, 
                                                        applyToolkitCss, 
                                                        useExtendedRange );
        _centerFrequencySelector = new CenterFrequencySelector( pClientProperties, 
                                                                applyToolkitCss,
                                                                startIndexForOneOctave,
                                                                startIndexForThirdOctave );
    }

    public String getCenterFrequency() {
        return _centerFrequencySelector.getCenterFrequency();
    }

    public String getOctaveRange() {
        return _octaveRangeSelector.getOctaveRange();
    }

    public RelativeBandwidth getRelativeBandwidth() {
        return _relativeBandwidthSelector.getRelativeBandwidth();
    }

    public void setCenterFrequency( final String sOctaveRange, final double centerFrequency ) {
        final String sCenterFrequency = FrequencySignalUtilities
                .getFormattedFrequency( centerFrequency, _numberFormat );
        _centerFrequencySelector.setCenterFrequency( sOctaveRange, sCenterFrequency );
    }

    public void setOctaveRange( final String sOctaveRange ) {
        _octaveRangeSelector.setOctaveRange( sOctaveRange );
    }

    public void setRelativeBandwidth( final RelativeBandwidth relativeBandwidth ) {
        _relativeBandwidthSelector.setRelativeBandwidth( relativeBandwidth );
    }

    public void updateCenterFrequencyForBandwidthAndOctave( final RelativeBandwidth relativeBandwidth,
                                                            final String sOctaveRange,
                                                            final double centerFrequency,
                                                            final boolean preserveSelection ) {
        _centerFrequencySelector.updateCenterFrequencyForBandwidthAndOctave( relativeBandwidth,
                                                                             sOctaveRange,
                                                                             centerFrequency,
                                                                             preserveSelection );
    }

    public void updateFrequencyRange( final FrequencyRange frequencyRange ) {
        // Select the new Frequency Range values, which must be pre-vetted as
        // valid. It is otherwise unsafe to set all three values at once.
        final RelativeBandwidth relativeBandwidth = frequencyRange.getRelativeBandwidth();
        final String sOctaveRange = frequencyRange.getOctaveRange();
        final double centerFrequency = frequencyRange.getCenterFrequency();

        setRelativeBandwidth( relativeBandwidth );
        updateOctaveRangeForBandwidthAndFrequency( relativeBandwidth,
                                                   sOctaveRange,
                                                   centerFrequency );
        final String sOctaveRangeCorrected = getOctaveRange();
        updateCenterFrequencyForBandwidthAndOctave( relativeBandwidth,
                                                    sOctaveRangeCorrected,
                                                    centerFrequency,
                                                    false );
    }

    public void updateOctaveRangeForBandwidthAndFrequency( final RelativeBandwidth relativeBandwidth,
                                                           final String sOctaveRange,
                                                           final double centerFrequency ) {
        _octaveRangeSelector.updateOctaveRangeForBandwidthAndFrequency( relativeBandwidth,
                                                                        centerFrequency );
    }
}
