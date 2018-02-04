package testapp

class BootStrap {

    def init = { servletContext ->
        Food food1 = new Food(name: "Test Food 1", amount: 100).save(failOnError: true)
    }
    def destroy = {
    }
}
