import React from 'react'
import styled from 'styled-components'

const CardDefault = styled.div`
    background-color: gray;
    padding: 20px;
    border-radius: 12px;
`

const CardPrimary = styled(CardDefault)`
    background-color: blue;
`

const SecondaryPrimary = styled(CardDefault)`
    background-color: green;
`

const token = 'YgPfXWGNZrZYPBa9TmPVkA'
const BASE_URL = 'https://app.fakejson.com/q/RkTmawC7'

export default function CardStyled () {
    return (
        <SecondaryPrimary>CardStyled</SecondaryPrimary>
    )
}
