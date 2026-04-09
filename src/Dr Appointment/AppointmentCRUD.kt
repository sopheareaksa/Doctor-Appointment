import kotlin.random.Random
class AppointmentCRUD {
    val app = ArrayList<Appointment>()
    fun bookAppointment(){
        print("Enter Patient Name: ")
        val na = readLine()
        print("Enter Phone Number: ")
        val ph = readLine()
        print("Enter Email: ")
        val em = readLine()
        print("Enter Age: ")
        val ag = readLine()
        print("Enter Gender: ")
        val ge = readLine()
        print("Enter Issue: ")
        val iu = readLine()

        val id: Int = Random.nextInt(100)
        var doctorname: String = ""
        if(iu == "Heart"){
            doctorname = "Dr SopheaReaksa"
        }
        else if(iu == "Kidney"){
            doctorname = "Dr ChanLeap"
        }
        val obj = Appointment(na,ph,em,ag,ge,iu)
        obj.appid = id
        obj.docname = doctorname

        app.add(obj)
        println("Appointment Booked with "+doctorname+" and Appointment ID is "+id)
    }
    fun viewAllAppointment(){
        for(a in app){
            println("Name: " + a.name)
            println("Age: " + a.age)
            println("Doctor: " + a.docname)
        }
    }
    fun viewAllDoctors(){
        println("Name"+" "+"Issue")
        println("Dr SopheaReaksa"+" "+"Heart")
        println("Dr ChanLeap"+" "+"Kidney")

    }
    fun rescheduleAppointment(){
        print("Enter Your Appointment ID: ")
        val input = readLine()
        if (input.isNullOrEmpty()) return
        val apid: Int = Integer.valueOf(input)

        // Safely find the index of the appointment
        val index = app.indexOfFirst { it.appid == apid }

        if (index != -1) {
            // Remove the old appointment outside of a loop
            app.removeAt(index)

            print("Enter Patient Name: ")
            val na = readLine()
            print("Enter Phone Number: ")
            val ph = readLine()
            print("Enter Email: ")
            val em = readLine()
            print("Enter Age: ")
            val ag = readLine()
            print("Enter Gender: ")
            val ge = readLine()
            print("Enter Issue: ")
            val iu = readLine()

            // Renamed to newId to avoid confusion with previous variables
            val newId: Int = Random.nextInt(100)
            var doctorname: String = ""
            if(iu == "Heart"){
                doctorname = "Dr SopheaReaksa"
            }
            else if(iu == "Kidney"){
                doctorname = "Dr ChanLeap"
            }

            // Assuming your Appointment class takes these parameters
            val obj = Appointment(na, ph, em, ag, ge, iu)
            obj.appid = newId
            obj.docname = doctorname

            app.add(obj)
            println("Appointment Rescheduled with " + doctorname + " and Appointment ID is " + newId)
        } else {
            println("Error: Appointment ID not found.")
        }
    }

    fun deleteAppointment(){
        print("Enter Appointment ID to cancel: ")
        val input = readLine()
        if (input.isNullOrEmpty()) return
        val apid = Integer.valueOf(input)

        // Safely find the index of the appointment
        val index = app.indexOfFirst { it.appid == apid }

        if(index != -1){
            app.removeAt(index)
            println("Your Appointment is Cancelled..")
        } else {
            println("Error: Appointment ID not found.")
        }
    }

}