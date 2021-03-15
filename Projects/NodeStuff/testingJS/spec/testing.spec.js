const {add} = require("..");

describe("Test my add function",()=>{
    it("should add 2+2 to equal 4",()=>{
        const result = add(2,2)
        expect(result).toBe(4)
    })

    it("should add 3+3 to equal 6",()=>{
        const result = add(3,3)
        expect(result).toBe(6)
    })
});
