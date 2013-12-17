package org.ccw.pdf.util

import java.io.File
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.util.PDFTextStripper
import org.slf4j.LoggerFactory
import org.apache.lucene.document.Document
import org.apache.pdfbox.lucene.LucenePDFDocument
import org.apache.pdfbox.pdmodel.PDDocumentInformation

class PDFParser

object PDFParser {

  val logger = LoggerFactory.getLogger(classOf[PDFParser])

  def getText(pdfFile: File, encoding: String): String = {
    var pddoc: PDDocument = null
    try {
      pddoc = PDDocument.load(pdfFile)
      val stripper = new PDFTextStripper(encoding)
      stripper.getText(pddoc)
    } finally {
      if (pddoc != null) {
        pddoc.close();
      }
    }
  }

  def getDocumentInformation(file: File): PDDocumentInformation = {
    var pddoc: PDDocument = null
    try {
      pddoc = PDDocument.load(file)
      pddoc.getDocumentInformation()

      // Exmaple to get the meta info
      /**
       * logger.info("Page Count=" + pddoc.getNumberOfPages());
       * logger.info("Title=" + info.getTitle());
       * logger.info("Author=" + info.getAuthor());
       * logger.info("Subject=" + info.getSubject());
       * logger.info("Keywords=" + info.getKeywords());
       */

    } finally {
      if (pddoc != null) {
        pddoc.close();
      }
    }

  }

}