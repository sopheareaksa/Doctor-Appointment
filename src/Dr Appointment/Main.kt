fun main(args: Array<String>) {
    var choice = 0
    val app = AppointmentCRUD()
    while (choice != 6) {
        println("-------Doctor's Appointment--------")
        println("1.Book An Appointment")
        println("2.Reschedule Your Appointment")
        println("3.Cancel Your Appointment")
        println("4.View All Appointments")
        println("5.View All Specialized Doctors")
        println("6.Close the Application")
        print("Enter Your Choice : ")
        choice = Integer.valueOf(readln())

        when (choice) {
            1 -> app.bookAppointment()
            2 -> app.rescheduleAppointment()
            3 -> app.deleteAppointment()
            4 -> app.viewAllAppointment()
            5 -> app.viewAllDoctors()
            6 -> break
            else -> println("Invalid Choice")
        }
    }
}
