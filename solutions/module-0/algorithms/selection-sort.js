// javascript implementation of the selection sort algorithm

var data = [9, 2, 3, 10, 6, 7, 14, 4];
sort(data);
console.log(data);

function sort(data) {

    var loopCount = 0;
    var tmp;

    while (loopCount < data.length) {

        for (var i = loopCount; i < data.length; i++) {
            if (data[i] < data[loopCount]) {
                tmp = data[i];
                data[i] = data[loopCount];
                data[loopCount] = tmp;
                break;
            }
        }

        loopCount++;

    }

}
