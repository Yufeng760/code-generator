function getGenIndictaorList(){
    return service.get('/generator/select')
}

function exportGenIndictaor(data){
    return service.post('/generator/export',data)
}

function insertGenIndictaor(data){
    return service.post('/generator/insert',{
        params:data
    })
}