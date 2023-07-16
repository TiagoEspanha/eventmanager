# eventmanager

## ENTIDADES

    ### USUÁRIO 
        - Pode ser de 3 tipos
            - admin (tem que ser marcado no banco)
                - pode criar EVENTOS
            - Organizador
                - De N eventos
                - 
            - Normal 
                - Pode favoritar uma ou mais atividades


    ### EVENTO
        - nome 
        - desc 
        - sigla
        - caminho
        - possui EDIÇÕES 

    ### EDICÃO
        - De um EVENTO
        - Criado por um USER (admin ou organizador)
        - Só tem um dono
            -
        - Possui uma ou mais ATIVIDADE

    ### ATIVIDADE
        - De um EVENTO
        - Acontece em um ESPAÇO

    ### ESPAÇO

## Paginas

    HOME
        - Ver descrição, data e local do evento
    
    Chamada 
        - Ver chamada de trabalhos dos eventos e prazos 
    
    Inscrições
        - Como se inscrever no evento
    
    Organização 
        - ver Equipe envolvida no evento

    Programação
        - Ver tabela com programacao do evento
        - Apresentar link para página de detalhamento da programacao 
        - Tem que mostrar as atividades favoritadas do usuário logado 

    Detalhamento 
        - Detalhes de uma programcao 
        - Ver lista de usuários que favoritaram essa atividade