bindThis(function(a, b){
    return this.test + a + b
}, {test:1})
(2,3)

function bindThis(f, oTarget) {

}