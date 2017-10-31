import projectdemo.Address
import projectdemo.Person

class BootStrap {

    def init = { servletContext ->
        def a1 = new Address(town: 't1', state: 's1').save()
        def a2 = new Address(town: 't2', state: 's2').save()
        def a3 = new Address(town: 't3', state: 's3').save()

        new Person(name: 'p1', homeAddress: a1).save()
        new Person(name: 'p1', homeAddress: a2).save()

        new Person(name: 'p3', homeAddress: a3).save()

        def q = Person.where {
            name == 'p1'
        }

        def homeAddresses = q.property('homeAddress').list()

        for(Object address : homeAddresses) {
            println "Instance: $address"
            if(address instanceof Address) {
                println '\tThe instance is an Address'
            } else {
                println '\tThe instance is NOT an Address'
            }
        }
    }
    def destroy = {
    }
}
