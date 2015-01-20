package org.checkerframework.checker.experimental.tainting_qual_poly;

import org.checkerframework.qualframework.poly.QualifierParameterChecker;
import org.checkerframework.qualframework.poly.format.SurfaceSyntaxFormatterConfiguration;
import org.checkerframework.qualframework.poly.format.SurfaceSyntaxQualParamsFormatter.AnnotationParts;

public class TaintingChecker extends QualifierParameterChecker<Tainting> {

    @Override
    protected TaintingQualifiedTypeFactory createTypeFactory() {
        return new TaintingQualifiedTypeFactory(this);
    }


    @Override
    protected SurfaceSyntaxFormatterConfiguration<Tainting> createSurfaceSyntaxFormatterConfiguration() {
        return new TaintingSurfaceSyntaxConfiguration();
    }

    private class TaintingSurfaceSyntaxConfiguration extends SurfaceSyntaxFormatterConfiguration<Tainting> {

        public TaintingSurfaceSyntaxConfiguration() {
            super(Tainting.TAINTED, Tainting.UNTAINTED,
                    TaintingChecker.this.getContext().getTypeFactory().getQualifierHierarchy().getTop(),
                    TaintingChecker.this.getContext().getTypeFactory().getQualifierHierarchy().getBottom());
        }

        @Override
        protected boolean shouldPrintAnnotation(AnnotationParts anno, boolean printInvisibleQualifiers) {
            return printInvisibleQualifiers;
        }

        @Override
        protected AnnotationParts getTargetTypeSystemAnnotation(Tainting qual) {

            switch(qual) {
                case TAINTED:
                    return new AnnotationParts("Tainted");
                case UNTAINTED:
                    return new AnnotationParts("Untainted");
                default:
                    return null; // Dead code
            }
        }
    }
}
