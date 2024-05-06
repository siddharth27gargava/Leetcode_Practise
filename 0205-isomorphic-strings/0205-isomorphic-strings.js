/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
    if(s.length !== t.length){
        return false;
    }

    let smap = {};
    let tmap = {};

    let spointer = 0;
    let tpointer = 0;

    while(spointer < s.length && tpointer < t.length){
        if((smap.hasOwnProperty(s.charAt(spointer)) && smap[s.charAt(spointer)] !== t.charAt(tpointer)) ||
        (tmap.hasOwnProperty(t.charAt(tpointer)) && tmap[t.charAt(tpointer)] !== s.charAt(spointer))){
            return false;
        }

        smap[s.charAt(spointer)] = t.charAt(tpointer);
        tmap[t.charAt(tpointer)] = s.charAt(spointer);

        spointer++;
        tpointer++
    }

    return true;
};