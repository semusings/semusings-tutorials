"use strict";

function process(state) {
    return state
}

module.exports = function plugin(md, options) {
    md.core.ruler.push("semusings-plugin-block", process);
};
