package de.berenberg.schulung

import de.berenberg.schulung.service.LectureService
import de.berenberg.schulung.action.CreateLectureAction
import org.springframework.boot.ApplicationRunner
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.stereotype.Component

@Component
class AppApplicationRunner(
    private val lectureService: LectureService,
    private val createLectureAction: CreateLectureAction
) : ApplicationRunner {

    private val log = LoggerFactory.getLogger(AppApplicationRunner::class.java)

    override fun run(args: ApplicationArguments) {
        log.debug(lectureService.contactEmailAddress)
        createLectureAction.execute()
    }
}
