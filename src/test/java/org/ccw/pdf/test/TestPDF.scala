package org.ccw.pdf.test

import org.scalatest.FlatSpec
import org.ccw.pdf.util.PDFParser
import java.io.File

class PDFTest extends FlatSpec {

  "A PDF Parser " should " throws FileNotFoundException if the given pdf file does not exist " in {
    intercept[java.io.FileNotFoundException] {
      PDFParser.getText(new File("abc.pdf"), "UTF-8")
    }
  }
}