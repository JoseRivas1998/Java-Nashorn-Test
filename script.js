print("Hello world!");

function test() {
    print("Hello from test!");
}

function helloTo(name)
{
    print("Hello, " + name + "!");
}

function runInput(inputManager) {
    print("Starting Input");
    inputManager.inputString("Test prompt", function (response) {
        print("Response: " + response);
    });
    print("Ending input")
}

test();
