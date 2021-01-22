// javascript implementation of the insertion sort algorithm

var data = [9, 2, 3, 10, 6, 7, 14, 4];

var sorted = sort(data);
console.log(sorted);

function sort(data) {

    var sortedArray = [];
    sortedArray.push(data[0]);

    for (var i = 1; i < data.length; i++) {

        for (var j = 0; j < sortedArray.length; j++) {

            if (data[i] < sortedArray[j]) {
                sortedArray.splice(j, 0, data[i]);
                break;
            }

        }

        if (j === sortedArray.length) {
            sortedArray.push(data[i]);
        }

    }

    return sortedArray;

}
