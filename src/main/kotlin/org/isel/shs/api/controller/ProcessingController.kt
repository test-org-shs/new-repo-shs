package org.isel.shs.api.controller

import org.isel.shs.api.dto.`in`.DependencyObject
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.zip.ZipInputStream

@RestController
@RequestMapping("/processing")
class ProcessingController {

    @GetMapping("hello")
    fun hello() = "Hello"
    @PostMapping("zip")
    fun receiveZip(file : MultipartFile) : ResponseEntity<String>{
        val zip = ZipInputStream(file.inputStream)
        var zipEntry = zip.nextEntry

        while (zipEntry != null) {
            val fileName = zipEntry.name
            // Process each file entry here
            println("Extracting: $fileName")

            // Do whatever processing needed for each file, like saving it or performing operations

            zipEntry = zip.nextEntry
        }

        zip.closeEntry()
        zip.close()
        return ResponseEntity.status(HttpStatus.OK).body("Success")
    }
    @PostMapping("json")
    fun receiveJson(@RequestBody list: List<DependencyObject>) : ResponseEntity<String>{
        list.forEach {
            logger.info("Parsing dependency with name ${it.fileName}")
        }


        return ResponseEntity.status(HttpStatus.OK).body("Success")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ProcessingController::class.java)
    }

}



