// Javascript implementation of the linear search algorithm
// iterative aproach used, -1 returned for not found as opposed to throwing
// an exception

var data = [41, 203, 901, 945, 775];
console.log(getIndexOf(data, 901));

function getIndexOf(data, value) {

    for (var i = 0; i < data.length; i++) {

        if (data[i] === value) {
            return i;
        }

    }

    return -1;

}
